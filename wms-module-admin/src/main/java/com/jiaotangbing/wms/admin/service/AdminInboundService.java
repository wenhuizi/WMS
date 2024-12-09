package com.jiaotangbing.wms.admin.service;

import com.jiaotangbing.wms.admin.model.vo.inbound.AddInboundReqVO;
import com.jiaotangbing.wms.admin.model.vo.inbound.DeleteInboundReqVO;
import com.jiaotangbing.wms.admin.model.vo.inbound.FindInboundPageListReqVO;
import com.jiaotangbing.wms.admin.model.vo.inbound.UpdateInboundReqVO;
import com.jiaotangbing.wms.common.utils.PageResponse;
import com.jiaotangbing.wms.common.utils.Response;

/**
 * @author lwh
 * @create 2024-12-08 20:03
 */
public interface AdminInboundService {

    /**
     * 添加入库信息
     * @param addInboundReqVO
     * @return
     */
    Response addInbounnd(AddInboundReqVO addInboundReqVO);

    /**
     * 修改入库记录
     * @param updateInboundReqVO
     * @return
     */
    Response updateInbound(UpdateInboundReqVO updateInboundReqVO);

    /**
     * 删除入库记录
     * @param deleteInboundReqVO
     * @return
     */
    Response deleteInbound(DeleteInboundReqVO deleteInboundReqVO);

    /**
     * 入库信息分页查询
     * @param findInboundPageListReqVO
     * @return
     */
    PageResponse findInboundList(FindInboundPageListReqVO findInboundPageListReqVO);
}
