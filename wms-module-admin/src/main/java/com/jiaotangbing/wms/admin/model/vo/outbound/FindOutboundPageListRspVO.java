package com.jiaotangbing.wms.admin.model.vo.outbound;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author lwh
 * @create 2024-12-09 10:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindOutboundPageListRspVO {

    private Long id;

    private String categoryName;

    private String materialName;

    private LocalDateTime outboundTime;

    private Double outboundNum;

    private String provider;

    private String attn;

    private String contractNo;

    private String notes;
}
