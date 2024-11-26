package com.jiaotangbing.wms.common.domain.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lwh
 * @create 2024-11-26 21:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_material")
public class MaterialDO {

    @TableId(type = IdType.AUTO)
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

    private Boolean isDeleted;
}
