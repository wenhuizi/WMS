package com.jiaotangbing.wms.admin.model.vo.state;

import com.jiaotangbing.wms.common.model.BasePageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author lwh
 * @create 2024-12-03 17:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "查询状态分页数据入参 VO")
public class FindStatePageListReqVO extends BasePageQuery {

    /**
     * 分类名称
     */
    private String stateName;

    /**
     * 创建的起始日期
     */
    private LocalDate startDate;

    /**
     * 创建的结束日期
     */
    private LocalDate endDate;

}
