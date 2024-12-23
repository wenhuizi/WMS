package com.jiaotangbing.wms.common.domain.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

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

    private Date nowStateTime;

    private String nowNextState;

    private Date preStateTime;

    private String preStateNext;

    private Date solidStateFinishTime;

    private String solidStateNext;

    private Date depositStateOutTime;

    private String depositStateNext;

    private Date depositAgainOutTime;

    private Date entrustedProcessDeliveryTime;

    private String entrustedProcessStateNext;

    private Date returnCompanyTime;

    private String returnCompanyNext;

    private Date heatStateFinishTime;

    private String heatStateNext;

    private Date machiningStateFinishTime;

    private String machiningStateNextState;

    private Date coatingStateFinishTime;

    private String coatingStateNextState;

    private Date finishedProductInboundTime;

    private String finishedProductNextState;

    private Date saleDeliveryTime;

    private String saleCustomer;

    private Date returnProductTime;

    private String returnProductLocation;

    private String notes;

    private Boolean isDeleted;
}
