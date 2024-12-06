package com.jiaotangbing.wms.admin.model.vo.material;

import com.jiaotangbing.wms.common.model.BasePageQuery;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lwh
 * @create 2024-12-06 11:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "根据原材料名查询原材料信息分页数据入参 VO")
public class FindMaterialPageListReqVO extends BasePageQuery {

    private String materialName;
}
