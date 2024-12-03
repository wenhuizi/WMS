package com.jiaotangbing.wms.admin.model.vo.state;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * @author lwh
 * @create 2024-12-03 19:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "删除状态 VO")
public class DeleteStateReqVO {

    @NotNull(message = "状态id不能为空")
    private Long id;
}
