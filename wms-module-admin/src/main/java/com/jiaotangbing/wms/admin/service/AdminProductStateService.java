package com.jiaotangbing.wms.admin.service;

import com.jiaotangbing.wms.admin.model.vo.productState.AddProductStateReqVO;
import com.jiaotangbing.wms.admin.model.vo.productState.DeleteProductStateReqVO;
import com.jiaotangbing.wms.admin.model.vo.productState.FindProductStatePageListReqVO;
import com.jiaotangbing.wms.admin.model.vo.productState.UpdateProductStateReqVO;
import com.jiaotangbing.wms.common.utils.PageResponse;
import com.jiaotangbing.wms.common.utils.Response;

/**
 * @author lwh
 * @create 2024-12-13 11:09
 */
public interface AdminProductStateService {

    /**
     * 添加产品状态信息
     * @param addProductStateReqVO
     * @return
     */
    Response addProductState(AddProductStateReqVO addProductStateReqVO);

    /**
     * 更新产品状态信息
     * @param updateProductStateReqVO
     * @return
     */
    Response updateProductState(UpdateProductStateReqVO updateProductStateReqVO);

    /**
     * 删除产品
     * @param deleteProductStateReqVO
     * @return
     */
    Response deleteProductState(DeleteProductStateReqVO deleteProductStateReqVO);

    /**
     * 产品信息分页查询
     * @param findProductStatePageListReqVO
     * @return
     */
    PageResponse findProductStateList(FindProductStatePageListReqVO findProductStatePageListReqVO);
}
