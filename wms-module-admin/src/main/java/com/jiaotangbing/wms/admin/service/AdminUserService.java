package com.jiaotangbing.wms.admin.service;

import com.jiaotangbing.wms.admin.model.vo.user.DeleteUserReqVO;
import com.jiaotangbing.wms.admin.model.vo.user.FindUserPageListReqVO;
import com.jiaotangbing.wms.admin.model.vo.user.UpdateUserReqVO;
import com.jiaotangbing.wms.admin.model.vo.user.UserRegisterReqVO;
import com.jiaotangbing.wms.common.utils.Response;

/**
 * @author lwh
 * @create 2024-12-03 17:16
 */
public interface AdminUserService {

    /**
     * 修改密码
     * @param updateUserReqVO
     * @return
     */
    Response updatePassword(UpdateUserReqVO updateUserReqVO);

    /**
     * 获取当前登录用户信息
     * @return
     */
    Response findUserInfo();

    /**
     * 注册新用户
     * @param userRegisterReqVO
     * @return
     */
    Response userRegister(UserRegisterReqVO userRegisterReqVO);

    /**
     * 用户注销
     * @param deleteUserReqVO
     * @return
     */
    Response deleteUser(DeleteUserReqVO deleteUserReqVO);

    /**
     * 分页获取该用户管理的所有用户信息
     * @return
     */
    Response findUserList(FindUserPageListReqVO findUserPageListReqVO);
}
