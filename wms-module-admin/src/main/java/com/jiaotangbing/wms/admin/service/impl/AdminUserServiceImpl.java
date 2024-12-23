package com.jiaotangbing.wms.admin.service.impl;

import com.jiaotangbing.wms.admin.model.vo.user.UpdateAdminUserReqVO;
import com.jiaotangbing.wms.admin.model.vo.user.UserRegisterReqVO;
import com.jiaotangbing.wms.admin.service.AdminUserService;
import com.jiaotangbing.wms.common.domain.dos.UserDO;
import com.jiaotangbing.wms.common.domain.mapper.UserMapper;
import com.jiaotangbing.wms.common.enums.ResponseCodeEnum;
import com.jiaotangbing.wms.common.exception.BizException;
import com.jiaotangbing.wms.common.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
    private PasswordEncoder passwordEncoder;

    @Override
    public Response updatePassword(UpdateAdminUserReqVO updateAdminUserReqVO) {
        // 拿到用户名、密码
        String username = updateAdminUserReqVO.getUsername();
        String password = updateAdminUserReqVO.getPassword();
        Integer telephone = updateAdminUserReqVO.getTelephone();

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
        UserDO userDO = userMapper.findByUsername(username);
        if(!Objects.nonNull(userDO)){
            log.warn("用户名： {}, 此用户名已存在", username);
            throw new BizException(ResponseCodeEnum.USERNAME_IS_EXISTED);
        }

        UserDO insertUserDO = UserDO.builder()
                .username(userRegisterReqVO.getUsername())
                .password(passwordEncoder.encode(userRegisterReqVO.getPassword()))
                .telephone(userRegisterReqVO.getTelephone())
                .build();

        userMapper.insert(insertUserDO);
        return Response.success();
    }
}
