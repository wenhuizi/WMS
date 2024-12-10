package com.jiaotangbing.wms.admin.model.vo.orderState;

import com.jiaotangbing.wms.common.model.BasePageQuery;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author lwh
 * @create 2024-12-10 23:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "查询订单信息分页数据入参 VO")
public class FindOrderStateReqVO extends BasePageQuery {

    private String OrderNo;

    private LocalDateTime OrderTime;

    private String productName;

    private String customer;

    /**
     * 创建的起始日期
     */
    private LocalDate startDate;

    /**
     * 创建的结束日期
     */
    private LocalDate endDate;
}
