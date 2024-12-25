package com.jiaotangbing.wms.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiaotangbing.wms.admin.model.vo.state.FindStatePageListRspVO;
import com.jiaotangbing.wms.admin.model.vo.user.*;
import com.jiaotangbing.wms.admin.service.AdminUserService;
import com.jiaotangbing.wms.common.domain.dos.StateDO;
import com.jiaotangbing.wms.common.domain.dos.UserDO;
import com.jiaotangbing.wms.common.domain.dos.UserRoleDO;
import com.jiaotangbing.wms.common.domain.mapper.UserMapper;
import com.jiaotangbing.wms.common.domain.mapper.UserRoleMapper;
import com.jiaotangbing.wms.common.enums.ResponseCodeEnum;
import com.jiaotangbing.wms.common.exception.BizException;
import com.jiaotangbing.wms.common.utils.PageResponse;
import com.jiaotangbing.wms.common.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author lwh
 * @create 2024-12-03 17:17
 */
@Service
@Slf4j
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Response updatePassword(UpdateUserReqVO updateUserReqVO) {
        // 拿到用户名、密码
        String username = updateUserReqVO.getUsername();
        String password = updateUserReqVO.getPassword();
        Integer telephone = updateUserReqVO.getTelephone();

        // 加密密码
        String encodePassword = passwordEncoder.encode(password);

        // 更新到数据库
        int count = userMapper.updateByUsername(username, encodePassword, telephone);

        return count == 1 ? Response.success() : Response.fail(ResponseCodeEnum.USERNAME_NOT_FOUND);
    }

    @Override
    public Response<UserDO> findUserInfo() {
        // 获取存储在 ThreadLocal 中的用户信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 拿到用户名
        String username = authentication.getName();
        UserDO userDO = userMapper.findByUsername(username);

        return Response.success(userDO);
    }

    @Override
    public Response userRegister(UserRegisterReqVO userRegisterReqVO) {
        String username = userRegisterReqVO.getUsername();
        String password = userRegisterReqVO.getPassword();
        String checkPassword = userRegisterReqVO.getCheckPassword();
        UserDO userDO = userMapper.findByUsername(username);
        if(Objects.nonNull(userDO)){
            log.warn("用户名： {}, 此用户名已存在", username);
            throw new BizException(ResponseCodeEnum.USERNAME_IS_EXISTED);
        }
        if(!checkPassword.equals(password)){
            throw new BizException(ResponseCodeEnum.PASSWORD_NOT_EQUALS);
        }

        UserDO insertUserDO = UserDO.builder()
                .username(userRegisterReqVO.getUsername())
                .password(passwordEncoder.encode(password))
                .telephone(userRegisterReqVO.getTelephone())
                .build();

        userMapper.insert(insertUserDO);
        return Response.success();
    }

    @Override
    public Response deleteUser(DeleteUserReqVO deleteUserReqVO) {
        Long id = deleteUserReqVO.getId();
        UserDO userDO = userMapper.selectById(id);
        String username = userDO.getUsername();
        LambdaQueryWrapper<UserRoleDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserRoleDO::getUsername, username);
        //删除用户角色分配
        userRoleMapper.delete(wrapper);
        //删除用户
        userMapper.deleteById(id);
        return Response.success();
    }

    //todo 错的逻辑
    @Override
    public PageResponse findUserList(FindUserPageListReqVO findUserPageListReqVO) {
        Long current = findUserPageListReqVO.getCurrent();
        Long size = findUserPageListReqVO.getSize();

        //所有用户信息
        Page<UserDO> userDOPage = userMapper.selectPageList(current, size, null, null);
        List<UserDO> userDOS = userDOPage.getRecords();

        //超级管理员用户信息
        String adminRole = "ROLE_ADMIN";
        UserRoleDO userRoleDO = userRoleMapper.selectByRole(adminRole);
        String adminName = userRoleDO.getUsername();
        UserDO removeAdminDO = userMapper.findByUsername(adminName);
        //删除超级管理员用户信息
        userDOS.remove(removeAdminDO);

        //如果是HR管理员，删除管理员用户信息
        // 获取存储在 ThreadLocal 中的用户信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 拿到用户名
        String username = authentication.getName();
        UserRoleDO userRoleDONow = userRoleMapper.selectByUsernameOne(username);
        //拿到当前角色
        String userRole = userRoleDONow.getRole();

        if(userRole.equals("ROLE_WMS_HR")){
            List<UserRoleDO> removeUserRoleDOS = userRoleMapper.selectByRoleList(userRole);
            Iterator<UserRoleDO> iterator = removeUserRoleDOS.iterator();
            while (iterator.hasNext()){
                UserRoleDO next = iterator.next();
                String nextUsername = next.getUsername();
                UserDO removeNextUserDO = userMapper.findByUsername(nextUsername);
                userDOS.remove(removeNextUserDO);
            }
        }



        List<FindUserPageListRspVO> vos = null;
        if (!CollectionUtils.isEmpty(userDOS)) {
            vos = userDOS.stream()
                    .map(userDO -> FindUserPageListRspVO.builder()
                            .id(userDO.getId())
                            .userName(userDO.getUsername())
                            .telephone(userDO.getTelephone())
                            .build())
                    .collect(Collectors.toList());
        }

        return PageResponse.success(userDOPage, vos);
    }
}
