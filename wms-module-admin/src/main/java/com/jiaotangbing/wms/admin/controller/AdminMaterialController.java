package com.jiaotangbing.wms.admin.controller;

import com.jiaotangbing.wms.admin.model.vo.material.AddMaterialReqVO;
import com.jiaotangbing.wms.admin.model.vo.material.DeleteMaterialReqVO;
import com.jiaotangbing.wms.admin.model.vo.material.FindMaterialPageListReqVO;
import com.jiaotangbing.wms.admin.model.vo.material.UpdateMaterialReqVO;
import com.jiaotangbing.wms.admin.service.AdminMaterialService;
import com.jiaotangbing.wms.common.aspect.ApiOperationLog;
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
 * @create 2024-12-06 10:04
 */
@RestController
@RequestMapping("/admin/material")
@Api(tags = "Admin 原材料信息模块")
public class AdminMaterialController {

    @Autowired
    private AdminMaterialService materialService;

    @PostMapping("/add")
    @ApiOperation(value = "添加原材料信息")
    @ApiOperationLog(description = "添加原材料信息")
    public Response addMaterial(@RequestBody @Validated AddMaterialReqVO addMaterialReqVO){
        return materialService.addMaterial(addMaterialReqVO);
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新原材料信息")
    @ApiOperationLog(description = "更新原材料信息")
    public Response updateMaterial(@RequestBody @Validated UpdateMaterialReqVO updateMaterialReqVO){
        return materialService.updateMaterial(updateMaterialReqVO);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除原材料信息")
    @ApiOperationLog(description = "删除原材料信息")
    public Response deleteMaterial(@RequestBody @Validated DeleteMaterialReqVO deleteMaterialReqVO){
        return materialService.deleteMaterial(deleteMaterialReqVO);
    }

    @PostMapping("/list/material")
    @ApiOperation(value = "根据原材料名查询分页数据")
    @ApiOperationLog(description = "根据原材料名查询分页数据")
    public Response findPageListByMaterialName(@RequestBody @Validated FindMaterialPageListReqVO findMaterialPageListReqVO) {
        return materialService.findPageListByMaterialName(findMaterialPageListReqVO);
    }

}
