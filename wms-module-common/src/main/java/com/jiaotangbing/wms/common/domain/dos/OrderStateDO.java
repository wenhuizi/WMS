package com.jiaotangbing.wms.common.domain.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lwh
 * @create 2024-11-26 22:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_order_state")
public class OrderStateDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String OrderNo;

    private Date OrderTime;

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

    private String notes;

    private Boolean isDeleted;
}
