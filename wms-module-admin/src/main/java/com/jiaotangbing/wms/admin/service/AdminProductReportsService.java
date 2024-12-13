package com.jiaotangbing.wms.admin.service;

import com.jiaotangbing.wms.admin.model.vo.productReports.AddProductReportsReqVO;
import com.jiaotangbing.wms.admin.model.vo.productReports.DeleteProductReportsReqVO;
import com.jiaotangbing.wms.admin.model.vo.productReports.FindProductReportsPageListReqVO;
import com.jiaotangbing.wms.admin.model.vo.productReports.UpdateProductReportsReqVO;
import com.jiaotangbing.wms.common.utils.PageResponse;
import com.jiaotangbing.wms.common.utils.Response;

/**
 * @author lwh
 * @create 2024-12-13 16:37
 */
public interface AdminProductReportsService {

    /**
     * 添加生产报表信息
     * @param addProductReportsReqVO
     * @return
     */
    Response addProductReports(AddProductReportsReqVO addProductReportsReqVO);

    /**
     * 更新生产报表信息
     * @param updateProductReportsReqVO
     * @return
     */
    Response updateProductReports(UpdateProductReportsReqVO updateProductReportsReqVO);

    /**
     * 删除生产报表
     * @param deleteProductReportsReqVO
     * @return
     */
    Response deleteProductReports(DeleteProductReportsReqVO deleteProductReportsReqVO);

    /**
     * 生产报表信息分页查询
     * @param findProductReportsPageListReqVO
     * @return
     */
    PageResponse findProductReportsList(FindProductReportsPageListReqVO findProductReportsPageListReqVO);
}
