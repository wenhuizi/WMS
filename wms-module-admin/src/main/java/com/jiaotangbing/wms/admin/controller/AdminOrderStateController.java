package com.jiaotangbing.wms.admin.controller;

import com.jiaotangbing.wms.admin.model.vo.orderState.AddOrderStateReqVO;
import com.jiaotangbing.wms.admin.model.vo.orderState.DeleteOrderStateReqVO;
import com.jiaotangbing.wms.admin.model.vo.orderState.FindOrderStatePageListReqVO;
import com.jiaotangbing.wms.admin.model.vo.orderState.UpdateOrderStateReqVO;
import com.jiaotangbing.wms.admin.service.AdminOrderStateService;
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
 * @create 2024-12-11 15:53
 */
@RestController
@RequestMapping("/admin/orderState")
@Api(tags = "Admin 订单状态信息模块")
public class AdminOrderStateController {

    @Autowired
    private AdminOrderStateService orderStateService;

    @PostMapping("/add")
    @ApiOperation(value = "添加订单状态")
    @ApiOperationLog(description = "添加订单状态")
    public Response addOrderState(@RequestBody @Validated AddOrderStateReqVO addOrderStateReqVO){
        return orderStateService.addOrderState(addOrderStateReqVO);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改订单状态")
    @ApiOperationLog(description = "修改订单状态")
    public Response updateOrderState(@RequestBody @Validated UpdateOrderStateReqVO updateOrderStateReqVO){
        return orderStateService.updateOrderState(updateOrderStateReqVO);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除订单状态")
    @ApiOperationLog(description = "删除订单状态")
    public Response deleteOrderState(@RequestBody @Validated DeleteOrderStateReqVO deleteOrderStateReqVO){
        return orderStateService.deleteOrderState(deleteOrderStateReqVO);
    }

    @PostMapping("/list")
    @ApiOperation(value = "订单状态分页数据获取")
    @ApiOperationLog(description = "订单状态分页数据获取")
    public PageResponse findOrderStateList(@RequestBody @Validated FindOrderStatePageListReqVO findOrderStatePageListReqVO) {
        return orderStateService.findOrderStateList(findOrderStatePageListReqVO);
    }
}
