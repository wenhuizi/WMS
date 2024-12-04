package com.jiaotangbing.wms.admin.model.vo.materialCategory;

import com.jiaotangbing.wms.common.model.BasePageQuery;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author lwh
 * @create 2024-12-04 17:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "查询大类分页数据入参 VO")
public class FindMaterialCategoryPageListReqVO extends BasePageQuery {

    /**
     * 大类名称
     */
    private String categoryName;

    /**
     * 创建的起始日期
     */
    private LocalDate startDate;

    /**
     * 创建的结束日期
     */
    private LocalDate endDate;
}
