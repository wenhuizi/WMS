package com.jiaotangbing.wms.admin.service;

import com.jiaotangbing.wms.admin.model.vo.userRole.AddUserRoleReqVO;
import com.jiaotangbing.wms.admin.model.vo.userRole.DeleteUserRoleReqVO;
import com.jiaotangbing.wms.admin.model.vo.userRole.UpdateUserRoleReqVO;
import com.jiaotangbing.wms.common.utils.Response;

/**
 * @author lwh
 * @create 2024-12-25 9:29
 */
public interface AdminUserRoleService {

    /**
     * 为用户分配角色
     * @param addUserRoleReqVO
     * @return
     */
    Response AddUserRole(AddUserRoleReqVO addUserRoleReqVO);

    /**
     * 修改用户权限
     * @param updateUserRoleReqVO
     * @return
     */
    Response UpdateUserRole(UpdateUserRoleReqVO updateUserRoleReqVO);

    /**
     * 获取除超级管理员外的角色
     * @return
     */
    Response findUserRoleList();

    /**
     * 删除用户角色
     * @param deleteUserRoleReqVO
     * @return
     */
    Response DeleteUserRole(DeleteUserRoleReqVO deleteUserRoleReqVO);
}
