package com.jiaotangbing.wms.common.domain.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author lwh
 * @create 2024-11-26 22:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_product_state")
public class ProductStateDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String orderNo;

    private String specs;

    private String productNo;

    private String productName;

    private String nowState;

    private LocalDateTime nowStateTime;

    private String nowNextState;

    private LocalDateTime preStateTime;

    private String preStateNext;

    private LocalDateTime solidStateFinishTime;

    private String solidStateNext;

    private LocalDateTime depositStateOutTime;

    private String depositStateNext;

    private LocalDateTime depositAgainOutTime;

    private LocalDateTime entrustedProcessDeliveryTime;

    private String entrustedProcessStateNext;

    private LocalDateTime returnCompanyTime;

    private String returnCompanyNext;

    private LocalDateTime heatStateFinishTime;

    private String heatStateNext;

    private LocalDateTime machiningStateFinishTime;

    private String machiningStateNextState;

    private LocalDateTime coatingStateFinishTime;

    private String coatingStateNextState;

    private LocalDateTime finishedProductInboundTime;

    private String finishedProductNextState;

    private LocalDateTime saleDeliveryTime;

    private String saleCustomer;

    private LocalDateTime returnProductTime;

    private String returnProductLocation;

    private String notes;

    private Boolean isDeleted;
}
