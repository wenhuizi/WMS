package com.jiaotangbing.wms.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiaotangbing.wms.admin.model.vo.orderState.*;
import com.jiaotangbing.wms.admin.model.vo.outbound.FindOutboundPageListRspVO;
import com.jiaotangbing.wms.admin.service.AdminOrderStateService;
import com.jiaotangbing.wms.common.domain.dos.OrderStateDO;
import com.jiaotangbing.wms.common.domain.dos.OutboundDO;
import com.jiaotangbing.wms.common.domain.mapper.OrderStateMapper;
import com.jiaotangbing.wms.common.utils.PageResponse;
import com.jiaotangbing.wms.common.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    @Override
    public Response findOrderStateList(FindOrderStateReqVO findOrderStateReqVO) {
        Long current = findOrderStateReqVO.getCurrent();
        Long size = findOrderStateReqVO.getSize();

        Page<OrderStateDO> page = new Page<>(current, size);
        LambdaQueryWrapper<OrderStateDO> wrapper = new LambdaQueryWrapper<>();

        String productName = findOrderStateReqVO.getProductName();
        String customer = findOrderStateReqVO.getCustomer();
        LocalDate startDate = findOrderStateReqVO.getStartDate();
        LocalDate endDate = findOrderStateReqVO.getEndDate();

        wrapper
                .like(StringUtils.isNotBlank(productName), OrderStateDO::getProductName, productName.trim()) // like 模块查询
                .like(StringUtils.isNotBlank(customer), OrderStateDO::getCustomer, customer.trim())
                .ge(Objects.nonNull(startDate), OrderStateDO::getOrderTime, startDate) // 大于等于 startDate
                .le(Objects.nonNull(endDate), OrderStateDO::getOrderTime, endDate)  // 小于等于 endDate
                .orderByDesc(OrderStateDO::getOrderTime); // 按创建时间倒叙

        Page<OrderStateDO> orderStateDOPage = orderStateMapper.selectPage(page, wrapper);

        List<OrderStateDO> orderStateDOS = orderStateDOPage.getRecords();

        List<FindOrderStateRspVO> vos = null;
        if (!CollectionUtils.isEmpty(orderStateDOS)) {
            vos = orderStateDOS.stream()
                    .map(orderStateDO -> FindOrderStateRspVO.builder()
                            .id(orderStateDO.getId())
                            .OrderNo(orderStateDO.getOrderNo())
                            .OrderTime(orderStateDO.getOrderTime())
                            .productName(orderStateDO.getProductName())
                            .preSpecsNo(orderStateDO.getPreSpecsNo())
                            .finishedProductSpecs(orderStateDO.getFinishedProductSpecs())
                            .unit(orderStateDO.getUnit())
                            .orderNum(orderStateDO.getOrderNum())
                            .uncuredNum(orderStateDO.getUncuredNum())
                            .curedNum(orderStateDO.getCuredNum())
                            .depositNum(orderStateDO.getDepositNum())
                            .depositAgainNum(orderStateDO.getDepositAgainNum())
                            .coatNum(orderStateDO.getCoatNum())
                            .finishNum(orderStateDO.getFinishNum())
                            .invalidNum(orderStateDO.getInvalidNum())
                            .saleNum(orderStateDO.getSaleNum())
                            .unproducedNum(orderStateDO.getUnproducedNum())
                            .productProgress(orderStateDO.getProductProgress())
                            .customer(orderStateDO.getCustomer())
                            .notes(orderStateDO.getNotes())
                            .build())
                    .collect(Collectors.toList());
        }

        return PageResponse.success(orderStateDOPage, vos);
    }

}
