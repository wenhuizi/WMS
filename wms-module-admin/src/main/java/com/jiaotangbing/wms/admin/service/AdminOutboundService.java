package com.jiaotangbing.wms.admin.service;

import com.jiaotangbing.wms.admin.model.vo.outbound.AddOutboundReqVO;
import com.jiaotangbing.wms.admin.model.vo.outbound.DeleteOutboundReqVO;
import com.jiaotangbing.wms.admin.model.vo.outbound.FindOutboundPageListReqVO;
import com.jiaotangbing.wms.admin.model.vo.outbound.UpdateOutboundReqVO;
import com.jiaotangbing.wms.common.utils.PageResponse;
import com.jiaotangbing.wms.common.utils.Response;

/**
 * @author lwh
 * @create 2024-12-09 11:39
 */
public interface AdminOutboundService {

    /**
     * 添加出库信息
     * @param addOutboundReqVO
     * @return
     */
    Response addOutbounnd(AddOutboundReqVO addOutboundReqVO);

    /**
     * 修改入库记录
     * @param updateOutboundReqVO
     * @return
     */
    Response updateOutbound(UpdateOutboundReqVO updateOutboundReqVO);

    /**
     * 删除入库记录
     * @param deleteOutboundReqVO
     * @return
     */
    Response deleteOutbound(DeleteOutboundReqVO deleteOutboundReqVO);

    /**
     * 入库信息分页查询
     * @param findOutboundPageListReqVO
     * @return
     */
    PageResponse findOutboundList(FindOutboundPageListReqVO findOutboundPageListReqVO);
}
