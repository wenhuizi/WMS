package com.jiaotangbing.wms.admin.model.vo.orderState;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author lwh
 * @create 2024-12-09 21:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "删除订单信息 VO")
public class DeleteOrderStateReqVO {

    @NotNull(message = "订单 ID 不能为空")
    private Long id;
}
