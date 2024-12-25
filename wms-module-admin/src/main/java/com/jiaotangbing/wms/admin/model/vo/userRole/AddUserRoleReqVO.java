package com.jiaotangbing.wms.admin.model.vo.userRole;

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
@ApiModel(value = "分配用户角色 VO")
public class AddUserRoleReqVO {

    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名")
    private String username;

    @NotBlank(message = "角色不能为空")
    @ApiModelProperty(value = "角色")
    private String role;
}
