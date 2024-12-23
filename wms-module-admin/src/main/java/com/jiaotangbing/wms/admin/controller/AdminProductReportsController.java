package com.jiaotangbing.wms.admin.controller;

import com.jiaotangbing.wms.admin.model.vo.productReports.AddProductReportsReqVO;
import com.jiaotangbing.wms.admin.model.vo.productReports.DeleteProductReportsReqVO;
import com.jiaotangbing.wms.admin.model.vo.productReports.FindProductReportsPageListReqVO;
import com.jiaotangbing.wms.admin.model.vo.productReports.UpdateProductReportsReqVO;
import com.jiaotangbing.wms.admin.service.AdminProductReportsService;
import com.jiaotangbing.wms.common.aspect.ApiOperationLog;
import com.jiaotangbing.wms.common.utils.PageResponse;
import com.jiaotangbing.wms.common.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lwh
 * @create 2024-12-13 17:58
 */
@RestController
@RequestMapping("/admin/productReports")
@Api(tags = "Admin 生产报表模块")
public class AdminProductReportsController {

    @Autowired
    private AdminProductReportsService productReportsService;

    @PostMapping("/add")
    @ApiOperation(value = "添加生产报表")
    @ApiOperationLog(description = "添加生产报表")
    public Response addProductReports(@RequestBody @Validated AddProductReportsReqVO addProductReportsReqVO){
        return productReportsService.addProductReports(addProductReportsReqVO);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改生产报表")
    @ApiOperationLog(description = "修改生产报表")
    public Response updateProductReports(@RequestBody @Validated UpdateProductReportsReqVO updateProductReportsReqVO){
        return productReportsService.updateProductReports(updateProductReportsReqVO);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除生产报表")
    @ApiOperationLog(description = "删除生产报表")
    public Response deleteProductReports(@RequestBody @Validated DeleteProductReportsReqVO deleteProductReportsReqVO){
        return productReportsService.deleteProductReports(deleteProductReportsReqVO);
    }

    @PostMapping("/list")
    @ApiOperation(value = "产品状态分页数据获取")
    @ApiOperationLog(description = "产品状态分页数据获取")
    public PageResponse findProductReportsList(@RequestBody @Validated FindProductReportsPageListReqVO findProductReportsPageListReqVO) {
        return productReportsService.findProductReportsList(findProductReportsPageListReqVO);
    }
}
