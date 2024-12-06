package com.jiaotangbing.wms.admin.model.vo.material;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

/**
 * @author lwh
 * @create 2024-12-06 10:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "修改原材料信息 VO")
public class UpdateMaterialReqVO {

    @NotBlank(message = "原材料名称不能为空")
    @Length(min = 1, max = 10, message = "原材料名称字数限制 1~10 之间")
    private String materialName;

    @NotBlank(message = "大类名称不能为空")
    @Length(min = 1, max = 10, message = "大类名称字数限制 1~10 之间")
    private String categoryName;

    private String specs;

    private Double grammage;

    private Double width;

    private String intensity;

    private String unit;

    @PositiveOrZero(message = "库存必须为 0 或正数")
    private Double storeNum;

    @NotBlank(message = "供应商名称不能为空")
    private String provider;
}
