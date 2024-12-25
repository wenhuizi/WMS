package com.jiaotangbing.wms.admin.controller;

import com.jiaotangbing.wms.admin.model.vo.user.UpdateUserReqVO;
import com.jiaotangbing.wms.admin.model.vo.userRole.AddUserRoleReqVO;
import com.jiaotangbing.wms.admin.model.vo.userRole.UpdateUserRoleReqVO;
import com.jiaotangbing.wms.admin.service.AdminUserRoleService;
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
 * @create 2024-12-25 10:47
 */
@RestController
@RequestMapping("/admin/userRole")
@Api(tags = "Admin 用户角色模块")
public class AdminUserRoleController {

    @Autowired
    private AdminUserRoleService userRoleService;

    @PostMapping("/add")
    @ApiOperation(value = "为用户分配角色")
    @ApiOperationLog(description = "为用户分配角色")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_WMS_HR')")
    public Response addUserRole(@RequestBody @Validated AddUserRoleReqVO addUserRoleReqVO) {
        return userRoleService.AddUserRole(addUserRoleReqVO);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改用户角色")
    @ApiOperationLog(description = "修改用户角色")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_WMS_HR')")
    public Response updateUserRole(@RequestBody @Validated UpdateUserRoleReqVO updateUserRoleReqVO) {
        return userRoleService.UpdateUserRole(updateUserRoleReqVO);
    }

    @PostMapping("/select/list")
    @ApiOperation(value = "查询比自己等级低的 Select 角色数据")
    @ApiOperationLog(description = "查询比自己等级低的 Select 角色数据")
    public Response findRoleSelectList() {
        return userRoleService.findUserRoleList();
    }
}
