package com.jiaotangbing.wms.admin.model.vo.inbound;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author lwh
 * @create 2024-12-08 19:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "添加入库信息 VO")
public class AddInboundReqVO {

    @NotBlank(message = "原材料名称不能为空")
    @Length(min = 1, max = 10, message = "原材料名称字数限制 1~10 之间")
    private String materialName;

    @NotBlank(message = "大类名称不能为空")
    @Length(min = 1, max = 10, message = "大类名称字数限制 1~10 之间")
    private String categoryName;

    @NotNull(message = "入库数量不能为空")
    private Double inboundNum;

    @NotBlank(message = "供应商名称不能为空")
    private String provider;

    @NotBlank(message = "经办人不能为空")
    private String attn;

    @NotBlank(message = "合同号不能为空")
    private String contractNo;

    private String notes;
}
