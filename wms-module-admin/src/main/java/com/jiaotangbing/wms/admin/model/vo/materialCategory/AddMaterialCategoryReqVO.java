package com.jiaotangbing.wms.admin.model.vo.materialCategory;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author lwh
 * @create 2024-12-04 16:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "添加大类VO")
public class AddMaterialCategoryReqVO {

    @NotBlank(message = "大类名称不能为空")
    @Length(min = 1, max = 10, message = "大类名称字数限制 1~10 之间")
    private String categoryName;
}
