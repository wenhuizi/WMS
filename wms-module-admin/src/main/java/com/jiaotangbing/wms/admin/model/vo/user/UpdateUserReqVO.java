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
 * @create 2024-12-03 17:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "修改用户信息 VO")
public class UpdateUserReqVO {

    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名")
    private String username;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码")
    private String password;

    @NotNull(message = "联系电话不能为空")
    @ApiModelProperty(value = "联系电话")
    private Integer telephone;
}

