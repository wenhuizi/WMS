package com.jiaotangbing.wms.admin.model.vo.user;

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
public class FindUserPageListRspVO {

    /**
     * 状态 ID
     */
    private Long id;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 联系电话
     */
    private Integer telephone;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
