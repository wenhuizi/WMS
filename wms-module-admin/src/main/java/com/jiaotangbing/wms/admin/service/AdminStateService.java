package com.jiaotangbing.wms.admin.service;

import com.jiaotangbing.wms.admin.model.vo.state.AddStateReqVO;
import com.jiaotangbing.wms.admin.model.vo.state.DeleteStateReqVO;
import com.jiaotangbing.wms.admin.model.vo.state.FindStatePageListReqVO;
import com.jiaotangbing.wms.common.utils.PageResponse;
import com.jiaotangbing.wms.common.utils.Response;

/**
 * @author lwh
 * @create 2024-12-03 16:41
 */
public interface AdminStateService {

    /**
     * 添加状态
     * @param addStateReqVO
     * @return
     */
    Response addState(AddStateReqVO addStateReqVO);

    /**
     * 状态分页数据查询
     * @param findStatePageListReqVO
     * @return
     */
    PageResponse findStateList(FindStatePageListReqVO findStatePageListReqVO);

    /**
     * 删除状态
     * @param deleteStateReqVO
     * @return
     */
    Response deleteState(DeleteStateReqVO deleteStateReqVO);
}
