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
 * @create 2024-12-23 17:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "注册用户 VO")
public class UserRegisterReqVO {

    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名")
    private String username;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码")
    private String password;

    @NotBlank(message = "验证密码不能为空")
    @ApiModelProperty(value = "验证密码")
    private String checkPassword;

    @NotNull(message = "联系电话不能为空")
    @ApiModelProperty(value = "联系电话")
    private Integer telephone;
}
