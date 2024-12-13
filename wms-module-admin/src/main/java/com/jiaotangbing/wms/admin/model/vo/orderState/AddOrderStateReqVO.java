package com.jiaotangbing.wms.admin.model.vo.orderState;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author lwh
 * @create 2024-12-09 20:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "添加订单状态信息 VO")
public class AddOrderStateReqVO {

    @NotBlank(message = "订单编码不能为空")
    private String OrderNo;

    private LocalDateTime OrderTime;

    @NotBlank(message = "产品名称不能为空")
    private String productName;

    @NotBlank(message = "预制体规格型号不能为空")
    private String preSpecsNo;

    @NotBlank(message = "成品规格不能为空")
    private String finishedProductSpecs;

    @NotBlank(message = "单位不能为空")
    private String unit;

    @NotNull(message = "订单数量不能为空")
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
}
