package com.jiaotangbing.wms.admin.controller;

import com.jiaotangbing.wms.admin.model.vo.materialCategory.AddMaterialCategoryReqVO;
import com.jiaotangbing.wms.admin.model.vo.materialCategory.DeleteMaterialCategoryReqVO;
import com.jiaotangbing.wms.admin.model.vo.materialCategory.FindMaterialCategoryPageListReqVO;
import com.jiaotangbing.wms.admin.model.vo.state.DeleteStateReqVO;
import com.jiaotangbing.wms.admin.model.vo.state.FindStatePageListReqVO;
import com.jiaotangbing.wms.admin.service.AdminMaterialCategoryService;
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
 * @create 2024-12-04 16:28
 */
@RestController
@RequestMapping("/admin/category")
@Api(tags = "Admin 大类模块")
public class AdminMaterialCategoryController {

    @Autowired
    private AdminMaterialCategoryService materialCategoryService;

    @PostMapping("/add")
    @ApiOperation(value = "添加大类")
    @ApiOperationLog(description = "添加大类")
    public Response addMaterialCategory(@RequestBody @Validated AddMaterialCategoryReqVO addMaterialCategoryReqVO){
        return materialCategoryService.addMaterialCategory(addMaterialCategoryReqVO);
    }

    @PostMapping("/list")
    @ApiOperation(value = "大类分页数据获取")
    @ApiOperationLog(description = "大类分页数据获取")
    public PageResponse findMaterialCategoryList(@RequestBody @Validated FindMaterialCategoryPageListReqVO findMaterialCategoryPageListReqVO) {
        return materialCategoryService.findMaterialCategoryList(findMaterialCategoryPageListReqVO);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除大类")
    @ApiOperationLog(description = "删除大类")
    public Response deleteMaterialCategory(@RequestBody @Validated DeleteMaterialCategoryReqVO deleteMaterialCategoryReqVO){
        return materialCategoryService.deleteMaterialCategory(deleteMaterialCategoryReqVO);
    }
}
