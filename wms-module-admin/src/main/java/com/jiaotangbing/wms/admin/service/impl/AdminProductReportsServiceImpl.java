package com.jiaotangbing.wms.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiaotangbing.wms.admin.model.vo.productReports.*;
import com.jiaotangbing.wms.admin.model.vo.productState.FindProductStatePageListRspVO;
import com.jiaotangbing.wms.admin.service.AdminProductReportsService;
import com.jiaotangbing.wms.common.domain.dos.OrderStateDO;
import com.jiaotangbing.wms.common.domain.dos.ProductReportsDO;
import com.jiaotangbing.wms.common.domain.dos.ProductStateDO;
import com.jiaotangbing.wms.common.domain.mapper.ProductReportsMapper;
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
 * @create 2024-12-13 16:39
 */
@Service
@Slf4j
public class AdminProductReportsServiceImpl extends ServiceImpl<ProductReportsMapper,ProductReportsDO> implements AdminProductReportsService {

    @Autowired
    private ProductReportsMapper productReportsMapper;

    @Override
    public Response addProductReports(AddProductReportsReqVO addProductReportsReqVO) {
        ProductReportsDO productReportsDO = ProductReportsDO.builder()
                .productName(addProductReportsReqVO.getProductName())
                .createTime(addProductReportsReqVO.getCreateTime())
                .prefabPreNum(addProductReportsReqVO.getPrefabPreNum())
                .prefabNum(addProductReportsReqVO.getPrefabNum())
                .prefabOutboundNum(addProductReportsReqVO.getPrefabOutboundNum())
                .prefabStoreNum(addProductReportsReqVO.getPrefabStoreNum())
                .curingPreNum(addProductReportsReqVO.getCuringPreNum())
                .curingNum(addProductReportsReqVO.getCuringNum())
                .curingOutboundNum(addProductReportsReqVO.getCuringOutboundNum())
                .curingStoreNum(addProductReportsReqVO.getCuringStoreNum())
                .depositPreNum(addProductReportsReqVO.getDepositPreNum())
                .depositNum(addProductReportsReqVO.getDepositNum())
                .depositOutboundNum(addProductReportsReqVO.getDepositOutboundNum())
                .depositStoreNum(addProductReportsReqVO.getDepositStoreNum())
                .depositAgainPreNum(addProductReportsReqVO.getDepositAgainPreNum())
                .depositAgainNum(addProductReportsReqVO.getDepositAgainNum())
                .depositAgainOutboundNum(addProductReportsReqVO.getDepositAgainOutboundNum())
                .depositAgainStoreNum(addProductReportsReqVO.getDepositAgainStoreNum())
                .entrustedProcessPreNum(addProductReportsReqVO.getEntrustedProcessPreNum())
                .entrustedProcessNum(addProductReportsReqVO.getEntrustedProcessNum())
                .entrustedProcessInboundNum(addProductReportsReqVO.getEntrustedProcessInboundNum())
                .entrustedProcessSaleNum(addProductReportsReqVO.getEntrustedProcessSaleNum())
                .entrustedProcessStoreNum(addProductReportsReqVO.getEntrustedProcessStoreNum())
                .uninboundPreNum(addProductReportsReqVO.getUninboundPreNum())
                .uninboundNum(addProductReportsReqVO.getUninboundNum())
                .uninboundOutboundNum(addProductReportsReqVO.getUninboundOutboundNum())
                .uninboundStoreNum(addProductReportsReqVO.getUninboundStoreNum())
                .coatingPreNum(addProductReportsReqVO.getCoatingPreNum())
                .coatingNum(addProductReportsReqVO.getCoatingNum())
                .coatingOutboundNum(addProductReportsReqVO.getCoatingOutboundNum())
                .coatingStoreNum(addProductReportsReqVO.getCoatingStoreNum())
                .finishedPreNum(addProductReportsReqVO.getFinishedPreNum())
                .finishedNum(addProductReportsReqVO.getFinishedNum())
                .finishedSaleNum(addProductReportsReqVO.getFinishedSaleNum())
                .finishedStoreNum(addProductReportsReqVO.getFinishedStoreNum())
                .salePreNum(addProductReportsReqVO.getSalePreNum())
                .saleNum(addProductReportsReqVO.getSaleNum())
                .saleTotalNum(addProductReportsReqVO.getSaleTotalNum())
                .build();
        productReportsMapper.insert(productReportsDO);
        return Response.success();
    }

    @Override
    public Response updateProductReports(UpdateProductReportsReqVO updateProductReportsReqVO) {
        ProductReportsDO productReportsDO = ProductReportsDO.builder()
                .id(1L)
                .productName(updateProductReportsReqVO.getProductName())
                .createTime(updateProductReportsReqVO.getCreateTime())
                .prefabPreNum(updateProductReportsReqVO.getPrefabPreNum())
                .prefabNum(updateProductReportsReqVO.getPrefabNum())
                .prefabOutboundNum(updateProductReportsReqVO.getPrefabOutboundNum())
                .prefabStoreNum(updateProductReportsReqVO.getPrefabStoreNum())
                .curingPreNum(updateProductReportsReqVO.getCuringPreNum())
                .curingNum(updateProductReportsReqVO.getCuringNum())
                .curingOutboundNum(updateProductReportsReqVO.getCuringOutboundNum())
                .curingStoreNum(updateProductReportsReqVO.getCuringStoreNum())
                .depositPreNum(updateProductReportsReqVO.getDepositPreNum())
                .depositNum(updateProductReportsReqVO.getDepositNum())
                .depositOutboundNum(updateProductReportsReqVO.getDepositOutboundNum())
                .depositStoreNum(updateProductReportsReqVO.getDepositStoreNum())
                .depositAgainPreNum(updateProductReportsReqVO.getDepositAgainPreNum())
                .depositAgainNum(updateProductReportsReqVO.getDepositAgainNum())
                .depositAgainOutboundNum(updateProductReportsReqVO.getDepositAgainOutboundNum())
                .depositAgainStoreNum(updateProductReportsReqVO.getDepositAgainStoreNum())
                .entrustedProcessPreNum(updateProductReportsReqVO.getEntrustedProcessPreNum())
                .entrustedProcessNum(updateProductReportsReqVO.getEntrustedProcessNum())
                .entrustedProcessInboundNum(updateProductReportsReqVO.getEntrustedProcessInboundNum())
                .entrustedProcessSaleNum(updateProductReportsReqVO.getEntrustedProcessSaleNum())
                .entrustedProcessStoreNum(updateProductReportsReqVO.getEntrustedProcessStoreNum())
                .uninboundPreNum(updateProductReportsReqVO.getUninboundPreNum())
                .uninboundNum(updateProductReportsReqVO.getUninboundNum())
                .uninboundOutboundNum(updateProductReportsReqVO.getUninboundOutboundNum())
                .uninboundStoreNum(updateProductReportsReqVO.getUninboundStoreNum())
                .coatingPreNum(updateProductReportsReqVO.getCoatingPreNum())
                .coatingNum(updateProductReportsReqVO.getCoatingNum())
                .coatingOutboundNum(updateProductReportsReqVO.getCoatingOutboundNum())
                .coatingStoreNum(updateProductReportsReqVO.getCoatingStoreNum())
                .finishedPreNum(updateProductReportsReqVO.getFinishedPreNum())
                .finishedNum(updateProductReportsReqVO.getFinishedNum())
                .finishedSaleNum(updateProductReportsReqVO.getFinishedSaleNum())
                .finishedStoreNum(updateProductReportsReqVO.getFinishedStoreNum())
                .salePreNum(updateProductReportsReqVO.getSalePreNum())
                .saleNum(updateProductReportsReqVO.getSaleNum())
                .saleTotalNum(updateProductReportsReqVO.getSaleTotalNum())
                .build();
        saveOrUpdate(productReportsDO);
        return Response.success();
    }

    @Override
    public Response deleteProductReports(DeleteProductReportsReqVO deleteProductReportsReqVO) {
        Long id = deleteProductReportsReqVO.getId();
        productReportsMapper.deleteById(id);
        return Response.success();
    }

    @Override
    public PageResponse findProductReportsList(FindProductReportsPageListReqVO findProductReportsPageListReqVO) {
        Long current = findProductReportsPageListReqVO.getCurrent();
        Long size = findProductReportsPageListReqVO.getSize();
        Page<ProductReportsDO> page = new Page<>(current, size);
        LambdaQueryWrapper<ProductReportsDO> wrapper = new LambdaQueryWrapper<>();

        LocalDate startDate = findProductReportsPageListReqVO.getStartDate();
        LocalDate endDate = findProductReportsPageListReqVO.getEndDate();

        wrapper
                .ge(Objects.nonNull(startDate), ProductReportsDO::getCreateTime, startDate) // 大于等于 startDate
                .le(Objects.nonNull(endDate), ProductReportsDO::getCreateTime, endDate)  // 小于等于 endDate
                .orderByDesc(ProductReportsDO::getCreateTime); // 按创建时间倒叙
        Page<ProductReportsDO> productReportsDOPage = productReportsMapper.selectPage(page, wrapper);
        List<ProductReportsDO> productReportsDOS = productReportsDOPage.getRecords();

        List<FindProductReportsPageListRspVO> vos = null;
        if (!CollectionUtils.isEmpty(productReportsDOS)) {
            vos = productReportsDOS.stream()
                    .map(productReportsDO -> FindProductReportsPageListRspVO.builder()
                            .id(productReportsDO.getId())
                            .productName(productReportsDO.getProductName())
                            .createTime(productReportsDO.getCreateTime())
                            .prefabPreNum(productReportsDO.getPrefabPreNum())
                            .prefabNum(productReportsDO.getPrefabNum())
                            .prefabOutboundNum(productReportsDO.getPrefabOutboundNum())
                            .prefabStoreNum(productReportsDO.getPrefabStoreNum())
                            .curingPreNum(productReportsDO.getCuringPreNum())
                            .curingNum(productReportsDO.getCuringNum())
                            .curingOutboundNum(productReportsDO.getCuringOutboundNum())
                            .curingStoreNum(productReportsDO.getCuringStoreNum())
                            .depositPreNum(productReportsDO.getDepositPreNum())
                            .depositNum(productReportsDO.getDepositNum())
                            .depositOutboundNum(productReportsDO.getDepositOutboundNum())
                            .depositStoreNum(productReportsDO.getDepositStoreNum())
                            .depositAgainPreNum(productReportsDO.getDepositAgainPreNum())
                            .depositAgainNum(productReportsDO.getDepositAgainNum())
                            .depositAgainOutboundNum(productReportsDO.getDepositAgainOutboundNum())
                            .depositAgainStoreNum(productReportsDO.getDepositAgainStoreNum())
                            .entrustedProcessPreNum(productReportsDO.getEntrustedProcessPreNum())
                            .entrustedProcessNum(productReportsDO.getEntrustedProcessNum())
                            .entrustedProcessInboundNum(productReportsDO.getEntrustedProcessInboundNum())
                            .entrustedProcessSaleNum(productReportsDO.getEntrustedProcessSaleNum())
                            .entrustedProcessStoreNum(productReportsDO.getEntrustedProcessStoreNum())
                            .uninboundPreNum(productReportsDO.getUninboundPreNum())
                            .uninboundNum(productReportsDO.getUninboundNum())
                            .uninboundOutboundNum(productReportsDO.getUninboundOutboundNum())
                            .uninboundStoreNum(productReportsDO.getUninboundStoreNum())
                            .coatingPreNum(productReportsDO.getCoatingPreNum())
                            .coatingNum(productReportsDO.getCoatingNum())
                            .coatingOutboundNum(productReportsDO.getCoatingOutboundNum())
                            .coatingStoreNum(productReportsDO.getCoatingStoreNum())
                            .finishedPreNum(productReportsDO.getFinishedPreNum())
                            .finishedNum(productReportsDO.getFinishedNum())
                            .finishedSaleNum(productReportsDO.getFinishedSaleNum())
                            .finishedStoreNum(productReportsDO.getFinishedStoreNum())
                            .salePreNum(productReportsDO.getSalePreNum())
                            .saleNum(productReportsDO.getSaleNum())
                            .saleTotalNum(productReportsDO.getSaleTotalNum())
                            .build())
                    .collect(Collectors.toList());
        }
        return PageResponse.success(productReportsDOPage, vos);
    }

}
