package com.jiaotangbing.wms.common.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lwh
 * @create 2024-08-30 20:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SelectRspVO {

    /**
     * Select 下拉列表的展示文字
     */
    private String label;

    /**
     * Select 下拉列表的value值，如 ID 等
     */
    private Object value;
}
