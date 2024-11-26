package com.jiaotangbing.wms.common.domain.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lwh
 * @create 2024-11-26 22:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_inbound")
public class InboundDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String categoryName;

    private String materialName;

    private Date inboundTime;

    private Double inboundNum;

    private String provider;

    private String attn;

    private String contractNo;

    private String notes;

    private Boolean isDeleted;
}
