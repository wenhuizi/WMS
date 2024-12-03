package com.jiaotangbing.wms.admin.service;

import com.jiaotangbing.wms.admin.model.vo.user.UpdateAdminUserPasswordReqVO;
import com.jiaotangbing.wms.common.utils.Response;

/**
 * @author lwh
 * @create 2024-12-03 17:16
 */
public interface AdminUserService {

    /**
     * 修改密码
     * @param updateAdminUserPasswordReqVO
     * @return
     */
    Response updatePassword(UpdateAdminUserPasswordReqVO updateAdminUserPasswordReqVO);

    /**
     * 获取当前登录用户信息
     * @return
     */
    Response findUserInfo();
}
