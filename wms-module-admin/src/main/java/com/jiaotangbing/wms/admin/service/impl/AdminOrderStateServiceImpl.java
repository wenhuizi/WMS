package com.jiaotangbing.wms.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiaotangbing.wms.admin.model.vo.orderState.AddOrderStateReqVO;
import com.jiaotangbing.wms.admin.model.vo.orderState.DeleteOrderStateReqVO;
import com.jiaotangbing.wms.admin.model.vo.orderState.UpdateOrderStateReqVO;
import com.jiaotangbing.wms.admin.service.AdminOrderStateService;
import com.jiaotangbing.wms.common.domain.dos.OrderStateDO;
import com.jiaotangbing.wms.common.domain.mapper.OrderStateMapper;
import com.jiaotangbing.wms.common.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lwh
 * @create 2024-12-09 21:00
 */
@Service
@Slf4j
public class AdminOrderStateServiceImpl extends ServiceImpl<OrderStateMapper,OrderStateDO> implements AdminOrderStateService {

    @Autowired
    private OrderStateMapper orderStateMapper;

    @Override
    public Response addOrderState(AddOrderStateReqVO addOrderStateReqVO) {
        OrderStateDO orderStateDO = OrderStateDO.builder()
                .OrderNo(addOrderStateReqVO.getOrderNo())
                .OrderTime(addOrderStateReqVO.getOrderTime())
                .productName(addOrderStateReqVO.getProductName())
                .preSpecsNo(addOrderStateReqVO.getPreSpecsNo())
                .finishedProductSpecs(addOrderStateReqVO.getFinishedProductSpecs())
                .unit(addOrderStateReqVO.getUnit())
                .orderNum(addOrderStateReqVO.getOrderNum())
                .uncuredNum(addOrderStateReqVO.getUncuredNum())
                .curedNum(addOrderStateReqVO.getCuredNum())
                .depositNum(addOrderStateReqVO.getDepositNum())
                .depositAgainNum(addOrderStateReqVO.getDepositAgainNum())
                .entrustedProcessNum(addOrderStateReqVO.getEntrustedProcessNum())
                .preparedInboundNum(addOrderStateReqVO.getPreparedInboundNum())
                .coatNum(addOrderStateReqVO.getCoatNum())
                .finishNum(addOrderStateReqVO.getFinishNum())
                .invalidNum(addOrderStateReqVO.getInvalidNum())
                .saleNum(addOrderStateReqVO.getSaleNum())
                .unproducedNum(addOrderStateReqVO.getUnproducedNum())
                .productProgress(addOrderStateReqVO.getProductProgress())
                .notes(addOrderStateReqVO.getNotes())
                .build();
        orderStateMapper.insert(orderStateDO);
        return Response.success();
    }

    @Override
    public Response updateOrderState(UpdateOrderStateReqVO updateOrderStateReqVO) {
        OrderStateDO orderStateDO = OrderStateDO.builder()
                .id(1L)
                .OrderNo(updateOrderStateReqVO.getOrderNo())
                .OrderTime(updateOrderStateReqVO.getOrderTime())
                .productName(updateOrderStateReqVO.getProductName())
                .preSpecsNo(updateOrderStateReqVO.getPreSpecsNo())
                .finishedProductSpecs(updateOrderStateReqVO.getFinishedProductSpecs())
                .unit(updateOrderStateReqVO.getUnit())
                .orderNum(updateOrderStateReqVO.getOrderNum())
                .uncuredNum(updateOrderStateReqVO.getUncuredNum())
                .curedNum(updateOrderStateReqVO.getCuredNum())
                .depositNum(updateOrderStateReqVO.getDepositNum())
                .depositAgainNum(updateOrderStateReqVO.getDepositAgainNum())
                .entrustedProcessNum(updateOrderStateReqVO.getEntrustedProcessNum())
                .preparedInboundNum(updateOrderStateReqVO.getPreparedInboundNum())
                .coatNum(updateOrderStateReqVO.getCoatNum())
                .finishNum(updateOrderStateReqVO.getFinishNum())
                .invalidNum(updateOrderStateReqVO.getInvalidNum())
                .saleNum(updateOrderStateReqVO.getSaleNum())
                .unproducedNum(updateOrderStateReqVO.getUnproducedNum())
                .productProgress(updateOrderStateReqVO.getProductProgress())
                .notes(updateOrderStateReqVO.getNotes())
                .build();
        saveOrUpdate(orderStateDO);
        return Response.success();
    }

    @Override
    public Response deleteOrderState(DeleteOrderStateReqVO deleteOrderStateReqVO) {
        Long id = deleteOrderStateReqVO.getId();
        orderStateMapper.deleteById(id);
        return Response.success();
    }
}
