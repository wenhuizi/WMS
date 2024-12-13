package com.jiaotangbing.wms.admin.model.vo.productState;

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
@ApiModel(value = "查询产品订单信息分页数据入参 VO")
public class FindProductStatePageListReqVO extends BasePageQuery {

    private String orderNo;

    private String productNo;

    private String productName;

    private String saleCustomer;

    /**
     * 创建的起始日期
     */
    private LocalDate startDate;

    /**
     * 创建的结束日期
     */
    private LocalDate endDate;
}
