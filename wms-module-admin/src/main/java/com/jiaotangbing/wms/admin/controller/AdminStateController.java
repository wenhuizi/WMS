package com.jiaotangbing.wms.admin.controller;

import com.jiaotangbing.wms.admin.model.vo.state.AddStateReqVO;
import com.jiaotangbing.wms.admin.model.vo.state.DeleteStateReqVO;
import com.jiaotangbing.wms.admin.model.vo.state.FindStatePageListReqVO;
import com.jiaotangbing.wms.admin.service.AdminStateService;
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
 * @create 2024-12-03 16:51
 */
@RestController
@RequestMapping("/admin")
@Api(tags = "Admin 状态模块")
public class AdminStateController {

    @Autowired
    private AdminStateService stateService;

    @PostMapping("/state/add")
    @ApiOperation(value = "添加状态")
    @ApiOperationLog(description = "添加状态")
    public Response addState(@RequestBody @Validated AddStateReqVO addStateReqVO){
        return stateService.addState(addStateReqVO);
    }

    @PostMapping("/state/list")
    @ApiOperation(value = "状态分页数据获取")
    @ApiOperationLog(description = "状态分页数据获取")
    public PageResponse findStateList(@RequestBody @Validated FindStatePageListReqVO findStatePageListReqVO) {
        return stateService.findStateList(findStatePageListReqVO);
    }

    @PostMapping("/state/delete")
    @ApiOperation(value = "删除状态")
    @ApiOperationLog(description = "删除状态")
    public Response deleteState(@RequestBody @Validated DeleteStateReqVO deleteStateReqVO){
        return stateService.deleteState(deleteStateReqVO);
    }
}
