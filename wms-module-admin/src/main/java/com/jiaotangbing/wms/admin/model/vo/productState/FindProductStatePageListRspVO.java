package com.jiaotangbing.wms.admin.model.vo.productState;

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
public class FindProductStatePageListRspVO {

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
}
