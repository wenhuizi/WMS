package com.jiaotangbing.wms.admin.model.vo.userRole;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


/**
 * @author lwh
 * @create 2024-12-03 17:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "修改用户角色信息 VO")
public class UpdateUserRoleReqVO {

    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名")
    private String username;

    @NotBlank(message = "角色不能为空")
    @ApiModelProperty(value = "角色")
    private String role;
}

