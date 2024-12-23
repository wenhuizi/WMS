package com.jiaotangbing.wms.admin.model.vo.materialCategory;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author lwh
 * @create 2024-12-23 17:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "修改大类信息 VO")
public class UpdateMaterialCategoryReqVO {

    @NotBlank(message = "大类名称不能为空")
    @Length(min = 1, max = 10, message = "大类名称字数限制 1~10 之间")
    private String categoryName;

    @NotBlank(message = "规格不能为空")
    private String specs;

    @NotNull(message = "库存不能为空")
    private Double storeNum;
}
