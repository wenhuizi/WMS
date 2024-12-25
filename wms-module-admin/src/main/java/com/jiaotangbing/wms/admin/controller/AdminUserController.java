package com.jiaotangbing.wms.admin.controller;

import com.jiaotangbing.wms.admin.model.vo.user.DeleteUserReqVO;
import com.jiaotangbing.wms.admin.model.vo.user.UpdateUserReqVO;
import com.jiaotangbing.wms.admin.model.vo.user.UserRegisterReqVO;
import com.jiaotangbing.wms.admin.service.AdminUserService;
import com.jiaotangbing.wms.common.aspect.ApiOperationLog;
import com.jiaotangbing.wms.common.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lwh
 * @create 2024-12-03 17:19
 */
@RestController
@RequestMapping("/admin")
@Api(tags = "Admin 用户模块")
public class AdminUserController {

    @Autowired
    private AdminUserService userService;

    @PostMapping("/user/update")
    @ApiOperation(value = "修改用户信息")
    @ApiOperationLog(description = "修改用户信息")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_WMS_HR')")
    public Response updatePassword(@RequestBody @Validated UpdateUserReqVO updateUserReqVO) {
        return userService.updatePassword(updateUserReqVO);
    }

    @PostMapping("/user/info")
    @ApiOperation(value = "获取用户信息")
    @ApiOperationLog(description = "获取用户信息")
    public Response findUserInfo() {
        return userService.findUserInfo();
    }

    @PostMapping("/user/register")
    @ApiOperation(value = "用户注册")
    @ApiOperationLog(description = "用户注册")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_WMS_HR')")
    public Response register(@RequestBody @Validated UserRegisterReqVO userRegisterReqVO){
        return userService.userRegister(userRegisterReqVO);
    }

    @PostMapping("/user/delete")
    @ApiOperation(value = "用户注销")
    @ApiOperationLog(description = "用户注销")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Response deleteUser(@RequestBody @Validated DeleteUserReqVO deleteUserReqVO){
        return userService.deleteUser(deleteUserReqVO);
    }
}
