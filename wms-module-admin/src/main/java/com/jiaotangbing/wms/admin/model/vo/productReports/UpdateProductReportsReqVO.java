package com.jiaotangbing.wms.admin.model.vo.productReports;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * @author lwh
 * @create 2024-12-09 21:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "修改生产报表信息 VO")
public class UpdateProductReportsReqVO {

    @NotBlank(message = "产品名称不能为空")
    private String productName;

    private LocalDateTime createTime;

    private Integer prefabPreNum;

    private Integer prefabNum;

    private Integer prefabOutboundNum;

    private Integer prefabStoreNum;

    private Integer curingPreNum;

    private Integer curingNum;

    private Integer curingOutboundNum;

    private Integer curingStoreNum;

    private Integer depositPreNum;

    private Integer depositNum;

    private Integer depositOutboundNum;

    private Integer depositStoreNum;

    private Integer depositAgainPreNum;

    private Integer depositAgainNum;

    private Integer depositAgainOutboundNum;

    private Integer depositAgainStoreNum;

    private Integer entrustedProcessPreNum;

    private Integer entrustedProcessNum;

    private Integer entrustedProcessInboundNum;

    private Integer entrustedProcessSaleNum;

    private Integer entrustedProcessStoreNum;

    private Integer uninboundPreNum;

    private Integer uninboundNum;

    private Integer uninboundOutboundNum;

    private Integer uninboundStoreNum;

    private Integer coatingPreNum;

    private Integer coatingNum;

    private Integer coatingOutboundNum;

    private Integer coatingStoreNum;

    private Integer finishedPreNum;

    private Integer finishedNum;

    private Integer finishedSaleNum;

    private Integer finishedStoreNum;

    private Integer salePreNum;

    private Integer saleNum;

    private Integer saleTotalNum;
}
