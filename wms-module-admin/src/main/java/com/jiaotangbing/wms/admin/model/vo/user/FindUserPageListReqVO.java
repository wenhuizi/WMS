package com.jiaotangbing.wms.admin.model.vo.user;

import com.jiaotangbing.wms.common.model.BasePageQuery;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author lwh
 * @create 2024-12-03 17:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "查询用户信息入参 VO")
public class FindUserPageListReqVO extends BasePageQuery {

}
