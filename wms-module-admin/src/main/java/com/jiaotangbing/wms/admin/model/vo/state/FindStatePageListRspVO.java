package com.jiaotangbing.wms.admin.model.vo.state;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author lwh
 * @create 2024-12-03 18:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindStatePageListRspVO {

    /**
     * 状态 ID
     */
    private Long id;

    /**
     * 状态名称
     */
    private String stateName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
