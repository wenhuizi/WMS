package com.jiaotangbing.wms.admin.model.vo.material;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lwh
 * @create 2024-12-06 11:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindMaterialPageListRspVO {

    private Long id;

    private String materialName;

    private String categoryName;

    private String specs;

    private Double grammage;

    private Double width;

    private String intensity;

    private String unit;

    private Double storeNum;

    private String provider;
}
