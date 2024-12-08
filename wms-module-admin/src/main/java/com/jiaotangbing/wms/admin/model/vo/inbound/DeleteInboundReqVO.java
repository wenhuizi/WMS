package com.jiaotangbing.wms.admin.model.vo.inbound;

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
@ApiModel(value = "删除入库记录 VO")
public class DeleteInboundReqVO {
    @NotNull(message = "入库记录 ID 不能为空")
    private Long id;
}
