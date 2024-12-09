package com.jiaotangbing.wms.admin.model.vo.outbound;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author lwh
 * @create 2024-12-08 20:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "删除出库记录 VO")
public class DeleteOutboundReqVO {

    @NotNull(message = "出库记录 ID 不能为空")
    private Long id;
}
