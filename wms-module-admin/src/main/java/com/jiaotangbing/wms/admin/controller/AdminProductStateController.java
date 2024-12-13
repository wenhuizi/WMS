package com.jiaotangbing.wms.admin.controller;

import com.jiaotangbing.wms.admin.model.vo.productState.AddProductStateReqVO;
import com.jiaotangbing.wms.admin.model.vo.productState.DeleteProductStateReqVO;
import com.jiaotangbing.wms.admin.model.vo.productState.FindProductStatePageListReqVO;
import com.jiaotangbing.wms.admin.model.vo.productState.UpdateProductStateReqVO;
import com.jiaotangbing.wms.admin.service.AdminProductStateService;
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
 * @create 2024-12-13 11:32
 */
@RestController
@RequestMapping("/admin/productState")
@Api(tags = "Admin 产品状态信息模块")
public class AdminProductStateController {

    @Autowired
    private AdminProductStateService productStateService;

    @PostMapping("/add")
    @ApiOperation(value = "添加产品状态")
    @ApiOperationLog(description = "添加产品状态")
    public Response addProductState(@RequestBody @Validated AddProductStateReqVO addProductStateReqVO){
        return productStateService.addProductState(addProductStateReqVO);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改产品状态")
    @ApiOperationLog(description = "修改产品状态")
    public Response updateProductState(@RequestBody @Validated UpdateProductStateReqVO updateProductStateReqVO){
        return productStateService.updateProductState(updateProductStateReqVO);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除产品状态")
    @ApiOperationLog(description = "删除产品状态")
    public Response deleteProductState(@RequestBody @Validated DeleteProductStateReqVO deleteProductStateReqVO){
        return productStateService.deleteProductState(deleteProductStateReqVO);
    }

    @PostMapping("/list")
    @ApiOperation(value = "产品状态分页数据获取")
    @ApiOperationLog(description = "产品状态分页数据获取")
    public PageResponse findProductStateList(@RequestBody @Validated FindProductStatePageListReqVO findProductStatePageListReqVO) {
        return productStateService.findProductStateList(findProductStatePageListReqVO);
    }
}
