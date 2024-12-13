package com.jiaotangbing.wms.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiaotangbing.wms.admin.model.vo.orderState.FindOrderStatePageListRspVO;
import com.jiaotangbing.wms.admin.model.vo.productState.*;
import com.jiaotangbing.wms.admin.service.AdminProductStateService;
import com.jiaotangbing.wms.common.domain.dos.OrderStateDO;
import com.jiaotangbing.wms.common.domain.dos.ProductStateDO;
import com.jiaotangbing.wms.common.domain.mapper.ProductStateMapper;
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
 * @create 2024-12-13 11:12
 */
@Service
@Slf4j
public class AdminProductStateServiceImpl extends ServiceImpl<ProductStateMapper, ProductStateDO> implements AdminProductStateService {

    @Autowired
    private ProductStateMapper productStateMapper;

    @Override
    public Response addProductState(AddProductStateReqVO addProductStateReqVO) {
        ProductStateDO productStateDO = ProductStateDO.builder()
                .orderNo(addProductStateReqVO.getOrderNo())
                .specs(addProductStateReqVO.getSpecs())
                .productNo(addProductStateReqVO.getProductNo())
                .productName(addProductStateReqVO.getProductName())
                .nowState(addProductStateReqVO.getNowState())
                .nowStateTime(addProductStateReqVO.getNowStateTime())
                .nowNextState(addProductStateReqVO.getNowNextState())
                .preStateTime(addProductStateReqVO.getPreStateTime())
                .preStateNext(addProductStateReqVO.getPreStateNext())
                .solidStateFinishTime(addProductStateReqVO.getSolidStateFinishTime())
                .solidStateNext(addProductStateReqVO.getSolidStateNext())
                .depositStateOutTime(addProductStateReqVO.getDepositStateOutTime())
                .depositStateNext(addProductStateReqVO.getDepositStateNext())
                .depositAgainOutTime(addProductStateReqVO.getDepositAgainOutTime())
                .entrustedProcessDeliveryTime(addProductStateReqVO.getEntrustedProcessDeliveryTime())
                .entrustedProcessStateNext(addProductStateReqVO.getEntrustedProcessStateNext())
                .returnCompanyTime(addProductStateReqVO.getReturnCompanyTime())
                .returnCompanyNext(addProductStateReqVO.getReturnCompanyNext())
                .heatStateFinishTime(addProductStateReqVO.getHeatStateFinishTime())
                .heatStateNext(addProductStateReqVO.getHeatStateNext())
                .machiningStateFinishTime(addProductStateReqVO.getMachiningStateFinishTime())
                .machiningStateNextState(addProductStateReqVO.getMachiningStateNextState())
                .coatingStateFinishTime(addProductStateReqVO.getCoatingStateFinishTime())
                .coatingStateNextState(addProductStateReqVO.getMachiningStateNextState())
                .finishedProductInboundTime(addProductStateReqVO.getFinishedProductInboundTime())
                .finishedProductNextState(addProductStateReqVO.getFinishedProductNextState())
                .saleDeliveryTime(addProductStateReqVO.getSaleDeliveryTime())
                .saleCustomer(addProductStateReqVO.getSaleCustomer())
                .returnProductTime(addProductStateReqVO.getReturnProductTime())
                .returnProductLocation(addProductStateReqVO.getReturnProductLocation())
                .notes(addProductStateReqVO.getNotes())
                .build();
        productStateMapper.insert(productStateDO);
        return Response.success();
    }

    @Override
    public Response updateProductState(UpdateProductStateReqVO updateProductStateReqVO) {
        ProductStateDO productStateDO = ProductStateDO.builder()
                .id(1L)
                .orderNo(updateProductStateReqVO.getOrderNo())
                .specs(updateProductStateReqVO.getSpecs())
                .productNo(updateProductStateReqVO.getProductNo())
                .productName(updateProductStateReqVO.getProductName())
                .nowState(updateProductStateReqVO.getNowState())
                .nowStateTime(updateProductStateReqVO.getNowStateTime())
                .nowNextState(updateProductStateReqVO.getNowNextState())
                .preStateTime(updateProductStateReqVO.getPreStateTime())
                .preStateNext(updateProductStateReqVO.getPreStateNext())
                .solidStateFinishTime(updateProductStateReqVO.getSolidStateFinishTime())
                .solidStateNext(updateProductStateReqVO.getSolidStateNext())
                .depositStateOutTime(updateProductStateReqVO.getDepositStateOutTime())
                .depositStateNext(updateProductStateReqVO.getDepositStateNext())
                .depositAgainOutTime(updateProductStateReqVO.getDepositAgainOutTime())
                .entrustedProcessDeliveryTime(updateProductStateReqVO.getEntrustedProcessDeliveryTime())
                .entrustedProcessStateNext(updateProductStateReqVO.getEntrustedProcessStateNext())
                .returnCompanyTime(updateProductStateReqVO.getReturnCompanyTime())
                .returnCompanyNext(updateProductStateReqVO.getReturnCompanyNext())
                .heatStateFinishTime(updateProductStateReqVO.getHeatStateFinishTime())
                .heatStateNext(updateProductStateReqVO.getHeatStateNext())
                .machiningStateFinishTime(updateProductStateReqVO.getMachiningStateFinishTime())
                .machiningStateNextState(updateProductStateReqVO.getMachiningStateNextState())
                .coatingStateFinishTime(updateProductStateReqVO.getCoatingStateFinishTime())
                .coatingStateNextState(updateProductStateReqVO.getMachiningStateNextState())
                .finishedProductInboundTime(updateProductStateReqVO.getFinishedProductInboundTime())
                .finishedProductNextState(updateProductStateReqVO.getFinishedProductNextState())
                .saleDeliveryTime(updateProductStateReqVO.getSaleDeliveryTime())
                .saleCustomer(updateProductStateReqVO.getSaleCustomer())
                .returnProductTime(updateProductStateReqVO.getReturnProductTime())
                .returnProductLocation(updateProductStateReqVO.getReturnProductLocation())
                .notes(updateProductStateReqVO.getNotes())
                .build();
        saveOrUpdate(productStateDO);
        return Response.success();
    }

    @Override
    public Response deleteProductState(DeleteProductStateReqVO deleteProductStateReqVO) {
        Long id = deleteProductStateReqVO.getId();
        productStateMapper.deleteById(id);
        return Response.success();
    }

    @Override
    public PageResponse findProductStateList(FindProductStatePageListReqVO findProductStatePageListReqVO) {
        Long current = findProductStatePageListReqVO.getCurrent();
        Long size = findProductStatePageListReqVO.getSize();
        Page<ProductStateDO> page = new Page<>(current, size);
        LambdaQueryWrapper<ProductStateDO> wrapper = new LambdaQueryWrapper<>();

        String orderNo = findProductStatePageListReqVO.getOrderNo();
        String productNo = findProductStatePageListReqVO.getProductNo();
        String productName = findProductStatePageListReqVO.getProductName();
        String saleCustomer = findProductStatePageListReqVO.getSaleCustomer();
        LocalDate startDate = findProductStatePageListReqVO.getStartDate();
        LocalDate endDate = findProductStatePageListReqVO.getEndDate();

        wrapper
                .like(StringUtils.isNotBlank(orderNo), ProductStateDO::getOrderNo, orderNo.trim()) // like 模块查询
                .like(StringUtils.isNotBlank(productNo), ProductStateDO::getProductNo, productNo.trim())
                .like(StringUtils.isNotBlank(productName), ProductStateDO::getProductName, productName.trim())
                .like(StringUtils.isNotBlank(saleCustomer), ProductStateDO::getSaleCustomer, saleCustomer.trim());

        Page<ProductStateDO> productStateDOPage = productStateMapper.selectPage(page, wrapper);
        List<ProductStateDO> productStateDOS = productStateDOPage.getRecords();

        List<FindProductStatePageListRspVO> vos = null;
        if (!CollectionUtils.isEmpty(productStateDOS)) {
            vos = productStateDOS.stream()
                    .map(productStateDO -> FindProductStatePageListRspVO.builder()
                            .id(productStateDO.getId())
                            .orderNo(productStateDO.getOrderNo())
                            .specs(productStateDO.getSpecs())
                            .productNo(productStateDO.getProductNo())
                            .productName(productStateDO.getProductName())
                            .nowState(productStateDO.getNowState())
                            .nowStateTime(productStateDO.getNowStateTime())
                            .nowNextState(productStateDO.getNowNextState())
                            .preStateTime(productStateDO.getPreStateTime())
                            .preStateNext(productStateDO.getPreStateNext())
                            .solidStateFinishTime(productStateDO.getSolidStateFinishTime())
                            .solidStateNext(productStateDO.getSolidStateNext())
                            .depositStateOutTime(productStateDO.getDepositStateOutTime())
                            .depositStateNext(productStateDO.getDepositStateNext())
                            .depositAgainOutTime(productStateDO.getDepositAgainOutTime())
                            .entrustedProcessDeliveryTime(productStateDO.getEntrustedProcessDeliveryTime())
                            .entrustedProcessStateNext(productStateDO.getEntrustedProcessStateNext())
                            .returnCompanyTime(productStateDO.getReturnCompanyTime())
                            .returnCompanyNext(productStateDO.getReturnCompanyNext())
                            .heatStateFinishTime(productStateDO.getHeatStateFinishTime())
                            .heatStateNext(productStateDO.getHeatStateNext())
                            .machiningStateFinishTime(productStateDO.getMachiningStateFinishTime())
                            .machiningStateNextState(productStateDO.getMachiningStateNextState())
                            .coatingStateFinishTime(productStateDO.getCoatingStateFinishTime())
                            .coatingStateNextState(productStateDO.getMachiningStateNextState())
                            .finishedProductInboundTime(productStateDO.getFinishedProductInboundTime())
                            .finishedProductNextState(productStateDO.getFinishedProductNextState())
                            .saleDeliveryTime(productStateDO.getSaleDeliveryTime())
                            .saleCustomer(productStateDO.getSaleCustomer())
                            .returnProductTime(productStateDO.getReturnProductTime())
                            .returnProductLocation(productStateDO.getReturnProductLocation())
                            .notes(productStateDO.getNotes())
                            .build())
                    .collect(Collectors.toList());
        }
        return PageResponse.success(productStateDOPage, vos);
    }
}
