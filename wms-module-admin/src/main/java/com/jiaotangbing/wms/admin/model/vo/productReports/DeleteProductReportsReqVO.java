package com.jiaotangbing.wms.admin.model.vo.productReports;

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
@ApiModel(value = "删除生产报表信息 VO")
public class DeleteProductReportsReqVO {

    @NotNull(message = "ID 不能为空")
    private Long id;
}
