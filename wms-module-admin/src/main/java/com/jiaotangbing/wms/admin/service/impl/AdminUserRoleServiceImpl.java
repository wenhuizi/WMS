package com.jiaotangbing.wms.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiaotangbing.wms.admin.model.vo.userRole.AddUserRoleReqVO;
import com.jiaotangbing.wms.admin.model.vo.userRole.DeleteUserRoleReqVO;
import com.jiaotangbing.wms.admin.model.vo.userRole.UpdateUserRoleReqVO;
import com.jiaotangbing.wms.admin.service.AdminUserRoleService;
import com.jiaotangbing.wms.common.domain.dos.UserDO;
import com.jiaotangbing.wms.common.domain.dos.UserRoleDO;
import com.jiaotangbing.wms.common.domain.mapper.UserMapper;
import com.jiaotangbing.wms.common.domain.mapper.UserRoleMapper;
import com.jiaotangbing.wms.common.enums.ResponseCodeEnum;
import com.jiaotangbing.wms.common.exception.BizException;
import com.jiaotangbing.wms.common.model.vo.SelectRspVO;
import com.jiaotangbing.wms.common.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author lwh
 * @create 2024-12-25 9:29
 */
@Service
@Slf4j
public class AdminUserRoleServiceImpl extends ServiceImpl<UserRoleMapper,UserRoleDO> implements AdminUserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Response AddUserRole(AddUserRoleReqVO addUserRoleReqVO) {
        String username = addUserRoleReqVO.getUsername();
        String role = addUserRoleReqVO.getRole();
        UserDO userDO = userMapper.findByUsername(username);
        if(!Objects.nonNull(userDO)){
            log.warn("用户名： {}, 此用户名不存在", username);
            throw new BizException(ResponseCodeEnum.USERNAME_IS_NOT_EXISTED);
        }
        UserRoleDO userRoleDO = UserRoleDO.builder()
                .username(username)
                .role(role)
                .build();
        userRoleMapper.insert(userRoleDO);
        return Response.success();
    }

    @Override
    public Response UpdateUserRole(UpdateUserRoleReqVO updateUserRoleReqVO) {
        String username = updateUserRoleReqVO.getUsername();
        UserDO userDO = userMapper.findByUsername(username);
        UserRoleDO userRoleDO = userRoleMapper.selectByUsernameOne(username);
        if(!Objects.nonNull(userDO)){
            log.warn("用户名： {}, 此用户名不存在", username);
            throw new BizException(ResponseCodeEnum.USERNAME_IS_NOT_EXISTED);
        }
        LambdaUpdateWrapper<UserRoleDO> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(UserRoleDO::getRole,updateUserRoleReqVO.getRole());
        wrapper.eq(UserRoleDO::getUsername, username);
        update(userRoleDO,wrapper);
        return Response.success();
    }

    @Override
    public Response findUserRoleList() {
        List<UserRoleDO> userRoleDOS = userRoleMapper.selectList(Wrappers.emptyWrapper());
        //超级管理员角色
        String role = "ROLE_ADMIN";
        LambdaQueryWrapper<UserRoleDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserRoleDO::getRole, role);
        List<UserRoleDO> removeUserRoleDOS = userRoleMapper.selectList(wrapper);

        //删除超级管理员角色
        userRoleDOS.removeAll(removeUserRoleDOS);

        // DO 转 VO
        List<SelectRspVO> vos = null;
        if (!CollectionUtils.isEmpty(userRoleDOS)) {
            vos = userRoleDOS.stream()
                    .map(userRoleDO -> SelectRspVO.builder()
                            .label(userRoleDO.getRole())
                            .value(userRoleDO.getId())
                            .build())
                    .collect(Collectors.toList());
        }

        return Response.success(vos);
    }

    @Override
    public Response DeleteUserRole(DeleteUserRoleReqVO deleteUserRoleReqVO) {
        Long id = deleteUserRoleReqVO.getId();
        userRoleMapper.deleteById(id);
        return Response.success();
    }
}
