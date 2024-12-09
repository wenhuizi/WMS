package com.jiaotangbing.wms.admin.model.vo.inbound;

import com.jiaotangbing.wms.common.model.BasePageQuery;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author lwh
 * @create 2024-12-09 10:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "查询入库信息分页数据入参 VO")
public class FindInboundPageListReqVO extends BasePageQuery {

    private String categoryName;

    private String materialName;

    private Double inboundNum;

    private String provider;

    private String attn;

    private String contractNo;

    /**
     * 创建的起始日期
     */
    private LocalDate startDate;

    /**
     * 创建的结束日期
     */
    private LocalDate endDate;
}
