package com.jiaotangbing.wms.admin.model.vo.materialCategory;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author lwh
 * @create 2024-12-04 17:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "删除大类 VO")
public class DeleteMaterialCategoryReqVO {

    @NotNull(message = "大类id不能为空")
    private Long id;
}
