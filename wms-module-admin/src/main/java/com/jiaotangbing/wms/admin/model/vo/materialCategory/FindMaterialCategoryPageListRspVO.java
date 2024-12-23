package com.jiaotangbing.wms.admin.model.vo.materialCategory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author lwh
 * @create 2024-12-04 17:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindMaterialCategoryPageListRspVO {

    /**
     * 大类 ID
     */
    private Long id;

    /**
     * 大类名称
     */
    private String categoryName;

    private String specs;

    private Double storeNum;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
