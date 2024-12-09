package com.jiaotangbing.wms.admin.model.vo.outbound;

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
 * @create 2024-12-08 20:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "修改出库信息 VO")
public class UpdateOutboundReqVO {

    @NotBlank(message = "原材料名称不能为空")
    @Length(min = 1, max = 10, message = "原材料名称字数限制 1~10 之间")
    private String materialName;

    @NotBlank(message = "大类名称不能为空")
    @Length(min = 1, max = 10, message = "大类名称字数限制 1~10 之间")
    private String categoryName;

    @NotNull(message = "出库数量不能为空")
    private Double outboundNum;

    @NotBlank(message = "供应商名称不能为空")
    private String provider;

    @NotBlank(message = "经办人不能为空")
    private String attn;

    @NotBlank(message = "合同号不能为空")
    private String contractNo;

    private String notes;
}
