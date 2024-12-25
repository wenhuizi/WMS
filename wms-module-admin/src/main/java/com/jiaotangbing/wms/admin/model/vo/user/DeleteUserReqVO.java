package com.jiaotangbing.wms.admin.model.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author lwh
 * @create 2024-12-03 19:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "用户注销 VO")
public class DeleteUserReqVO {

    @NotNull(message = "状态id不能为空")
    private Long id;

}
