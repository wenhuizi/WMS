package com.jiaotangbing.wms.admin.model.vo.state;

import io.swagger.annotations.ApiModel;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author lwh
 * @create 2024-12-03 16:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "添加状态VO")
public class AddStateReqVO {

    @NotBlank(message = "状态名称不能为空")
    @Length(min = 1, max = 10, message = "状态名称字数限制 1~10 之间")
    private String stateName;
}
