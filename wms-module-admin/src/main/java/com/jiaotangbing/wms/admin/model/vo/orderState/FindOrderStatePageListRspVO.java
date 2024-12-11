package com.jiaotangbing.wms.admin.model.vo.orderState;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author lwh
 * @create 2024-12-10 23:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindOrderStatePageListRspVO {

    private Long id;

    private String OrderNo;

    private LocalDateTime OrderTime;

    private String productName;

    private String preSpecsNo;

    private String finishedProductSpecs;

    private String unit;

    private Double orderNum;

    private Double uncuredNum;

    private Double curedNum;

    private Double depositNum;

    private Double depositAgainNum;

    private Double entrustedProcessNum;

    private Double preparedInboundNum;

    private Double coatNum;

    private Double finishNum;

    private Double invalidNum;

    private Double saleNum;

    private Double unproducedNum;

    private Double productProgress;

    private String customer;

    private String notes;
}
