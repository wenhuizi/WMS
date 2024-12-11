package com.jiaotangbing.wms.admin.service;

import com.jiaotangbing.wms.admin.model.vo.orderState.AddOrderStateReqVO;
import com.jiaotangbing.wms.admin.model.vo.orderState.DeleteOrderStateReqVO;
import com.jiaotangbing.wms.admin.model.vo.orderState.FindOrderStatePageListReqVO;
import com.jiaotangbing.wms.admin.model.vo.orderState.UpdateOrderStateReqVO;
import com.jiaotangbing.wms.common.utils.PageResponse;
import com.jiaotangbing.wms.common.utils.Response;

/**
 * @author lwh
 * @create 2024-12-09 20:29
 */
public interface AdminOrderStateService {

    /**
     * 添加订单状态信息
     * @param addOrderStateReqVO
     * @return
     */
    Response addOrderState(AddOrderStateReqVO addOrderStateReqVO);

    /**
     * 更新订单状态信息
     * @param updateOrderStateReqVO
     * @return
     */
    Response updateOrderState(UpdateOrderStateReqVO updateOrderStateReqVO);

    /**
     * 删除订单
     * @param deleteOrderStateReqVO
     * @return
     */
    Response deleteOrderState(DeleteOrderStateReqVO deleteOrderStateReqVO);

    /**
     * 订单信息分页查询
     * @param findOrderStatePageListReqVO
     * @return
     */
    PageResponse findOrderStateList(FindOrderStatePageListReqVO findOrderStatePageListReqVO);
}
