package com.jiaotangbing.wms.admin.model.vo.productState;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author lwh
 * @create 2024-12-09 21:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "删除产品状态信息 VO")
public class DeleteProductStateReqVO {

    @NotNull(message = "ID 不能为空")
    private Long id;
}
