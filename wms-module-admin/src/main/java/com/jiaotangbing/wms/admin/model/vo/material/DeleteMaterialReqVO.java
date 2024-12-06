package com.jiaotangbing.wms.admin.model.vo.material;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author lwh
 * @create 2024-12-06 10:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "删除原材料 VO")
public class DeleteMaterialReqVO {

    @NotNull(message = "原材料 ID 不能为空")
    private Long id;
}
