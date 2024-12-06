package com.jiaotangbing.wms.admin.service;

import com.jiaotangbing.wms.admin.model.vo.material.*;
import com.jiaotangbing.wms.admin.model.vo.state.AddStateReqVO;
import com.jiaotangbing.wms.common.utils.Response;

/**
 * @author lwh
 * @create 2024-12-06 9:55
 */
public interface AdminMaterialService {

    /**
     * 添加原材料信息
     * @param addMaterialReqVO
     * @return
     */
    Response addMaterial(AddMaterialReqVO addMaterialReqVO);

    /**
     * 修改原材料信息
     * @param updateMaterialReqVO
     * @return
     */
    Response updateMaterial(UpdateMaterialReqVO updateMaterialReqVO);

    /**
     * 删除原材料信息
     * @param deleteMaterialReqVO
     * @return
     */
    Response deleteMaterial(DeleteMaterialReqVO deleteMaterialReqVO);

    /**
     * 根据原材料名分页查询
     * @param findMaterialPageListReqVO
     * @return
     */
    Response findPageListByMaterialName(FindMaterialPageListReqVO findMaterialPageListReqVO);

    /**
     * 根据原大类名分页查询
     * @param findMaterialPageListByCategoryNameReqVO
     * @return
     */
    Response findPageListByCategoryName(FindMaterialPageListByCategoryNameReqVO findMaterialPageListByCategoryNameReqVO);

    /**
     * 根据供应商分页查询
     * @param findMaterialPageListByProviderReqVO
     * @return
     */
    Response findPageListByProvider(FindMaterialPageListByProviderReqVO findMaterialPageListByProviderReqVO);
}
