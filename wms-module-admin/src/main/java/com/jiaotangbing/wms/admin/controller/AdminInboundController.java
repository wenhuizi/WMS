package com.jiaotangbing.wms.admin.controller;

import com.jiaotangbing.wms.admin.model.vo.inbound.AddInboundReqVO;
import com.jiaotangbing.wms.admin.model.vo.inbound.DeleteInboundReqVO;
import com.jiaotangbing.wms.admin.model.vo.inbound.FindInboundPageListReqVO;
import com.jiaotangbing.wms.admin.model.vo.inbound.UpdateInboundReqVO;
import com.jiaotangbing.wms.admin.service.AdminInboundService;
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
 * @create 2024-12-08 20:29
 */
@RestController
@RequestMapping("/admin/inbound")
@Api(tags = "Admin 入库信息模块")
public class AdminInboundController {

    @Autowired
    private AdminInboundService inboundService;

    @PostMapping("/add")
    @ApiOperation(value = "添加入库记录")
    @ApiOperationLog(description = "添加入库记录")
    public Response addInbound(@RequestBody @Validated AddInboundReqVO addInboundReqVO){
        return inboundService.addInbounnd(addInboundReqVO);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改入库记录")
    @ApiOperationLog(description = "修改入库记录")
    public Response updateInbound(@RequestBody @Validated UpdateInboundReqVO updateInboundReqVO){
        return inboundService.updateInbound(updateInboundReqVO);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除入库记录")
    @ApiOperationLog(description = "删除入库记录")
    public Response deleteInbound(@RequestBody @Validated DeleteInboundReqVO deleteInboundReqVO){
        return inboundService.deleteInbound(deleteInboundReqVO);
    }

    @PostMapping("/list")
    @ApiOperation(value = "入库记录分页数据获取")
    @ApiOperationLog(description = "入库记录分页数据获取")
    public PageResponse findInboundList(@RequestBody @Validated FindInboundPageListReqVO findInboundPageListReqVO) {
        return inboundService.findInboundList(findInboundPageListReqVO);
    }
}
