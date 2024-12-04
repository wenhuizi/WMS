package com.jiaotangbing.wms.admin.service;

import com.jiaotangbing.wms.admin.model.vo.materialCategory.AddMaterialCategoryReqVO;
import com.jiaotangbing.wms.admin.model.vo.materialCategory.DeleteMaterialCategoryReqVO;
import com.jiaotangbing.wms.admin.model.vo.materialCategory.FindMaterialCategoryPageListReqVO;
import com.jiaotangbing.wms.admin.model.vo.state.AddStateReqVO;
import com.jiaotangbing.wms.admin.model.vo.state.FindStatePageListReqVO;
import com.jiaotangbing.wms.common.utils.PageResponse;
import com.jiaotangbing.wms.common.utils.Response;

/**
 * @author lwh
 * @create 2024-12-04 16:17
 */
public interface AdminMaterialCategoryService {

    /**
     * 添加大类
     * @param addMaterialCategoryReqVO
     * @return
     */
    Response addMaterialCategory(AddMaterialCategoryReqVO addMaterialCategoryReqVO);

    /**
     * 大类分页数据查询
     * @param findMaterialCategoryPageListReqVO
     * @return
     */
    PageResponse findMaterialCategoryList(FindMaterialCategoryPageListReqVO findMaterialCategoryPageListReqVO);

    /**
     * 删除大类
     * @param deleteMaterialCategoryReqVO
     * @return
     */
    Response deleteMaterialCategory(DeleteMaterialCategoryReqVO deleteMaterialCategoryReqVO);
}
