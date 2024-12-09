package com.jiaotangbing.wms.admin.model.vo.inbound;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author lwh
 * @create 2024-12-09 10:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindInboundPageListRspVO {

    private Long id;

    private String categoryName;

    private String materialName;

    private LocalDateTime inboundTime;

    private Double inboundNum;

    private String provider;

    private String attn;

    private String contractNo;

    private String notes;
}
