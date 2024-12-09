package com.jiaotangbing.wms.admin.controller;

import com.jiaotangbing.wms.admin.model.vo.outbound.AddOutboundReqVO;
import com.jiaotangbing.wms.admin.model.vo.outbound.DeleteOutboundReqVO;
import com.jiaotangbing.wms.admin.model.vo.outbound.FindOutboundPageListReqVO;
import com.jiaotangbing.wms.admin.model.vo.outbound.UpdateOutboundReqVO;
import com.jiaotangbing.wms.admin.service.AdminOutboundService;
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
 * @create 2024-12-09 11:47
 */
@RestController
@RequestMapping("/admin/outbound")
@Api(tags = "Admin 出库信息模块")
public class AdminOutboundController {

    @Autowired
    private AdminOutboundService outboundService;

    @PostMapping("/add")
    @ApiOperation(value = "添加入库记录")
    @ApiOperationLog(description = "添加入库记录")
    public Response addOutbound(@RequestBody @Validated AddOutboundReqVO addOutboundReqVO){
        return outboundService.addOutbounnd(addOutboundReqVO);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改入库记录")
    @ApiOperationLog(description = "修改入库记录")
    public Response updateOutbound(@RequestBody @Validated UpdateOutboundReqVO updateOutboundReqVO){
        return outboundService.updateOutbound(updateOutboundReqVO);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除入库记录")
    @ApiOperationLog(description = "删除入库记录")
    public Response deleteOutbound(@RequestBody @Validated DeleteOutboundReqVO deleteOutboundReqVO){
        return outboundService.deleteOutbound(deleteOutboundReqVO);
    }

    @PostMapping("/list")
    @ApiOperation(value = "入库记录分页数据获取")
    @ApiOperationLog(description = "入库记录分页数据获取")
    public PageResponse findOutboundList(@RequestBody @Validated FindOutboundPageListReqVO findOutboundPageListReqVO) {
        return outboundService.findOutboundList(findOutboundPageListReqVO);
    }
}
