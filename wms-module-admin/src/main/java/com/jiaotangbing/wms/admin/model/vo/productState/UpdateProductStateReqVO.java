package com.jiaotangbing.wms.admin.model.vo.productState;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.time.LocalDateTime;

/**
 * @author lwh
 * @create 2024-12-09 21:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "修改订单状态信息 VO")
public class UpdateProductStateReqVO {

    @NotBlank(message = "订单编码不能为空")
    private String orderNo;

    private String specs;

    @NotBlank(message = "产品编码不能为空")
    private String productNo;

    @NotBlank(message = "产品名称不能为空")
    private String productName;

    @NotBlank(message = "产品最新状态不能为空")
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
}
