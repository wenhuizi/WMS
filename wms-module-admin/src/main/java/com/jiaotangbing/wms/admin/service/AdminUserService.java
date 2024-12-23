package com.jiaotangbing.wms.admin.service;

import com.jiaotangbing.wms.admin.model.vo.user.UpdateAdminUserReqVO;
import com.jiaotangbing.wms.admin.model.vo.user.UserRegisterReqVO;
import com.jiaotangbing.wms.common.utils.Response;

/**
 * @author lwh
 * @create 2024-12-03 17:16
 */
public interface AdminUserService {

    /**
     * 修改密码
     * @param updateAdminUserReqVO
     * @return
     */
    Response updatePassword(UpdateAdminUserReqVO updateAdminUserReqVO);

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
}
