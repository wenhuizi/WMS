package com.jiaotangbing.wms.common.domain.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author lwh
 * @create 2024-11-25 12:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_state")
public class StateDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String stateName;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Boolean isDeleted;
}
