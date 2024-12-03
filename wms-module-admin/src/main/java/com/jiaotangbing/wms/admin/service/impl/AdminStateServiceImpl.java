package com.jiaotangbing.wms.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiaotangbing.wms.admin.model.vo.state.AddStateReqVO;
import com.jiaotangbing.wms.admin.model.vo.state.DeleteStateReqVO;
import com.jiaotangbing.wms.admin.model.vo.state.FindStatePageListReqVO;
import com.jiaotangbing.wms.admin.model.vo.state.FindStatePageListRspVO;
import com.jiaotangbing.wms.admin.service.AdminStateService;
import com.jiaotangbing.wms.common.domain.dos.StateDO;
import com.jiaotangbing.wms.common.domain.mapper.StateMapper;
import com.jiaotangbing.wms.common.enums.ResponseCodeEnum;
import com.jiaotangbing.wms.common.exception.BizException;
import com.jiaotangbing.wms.common.utils.PageResponse;
import com.jiaotangbing.wms.common.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author lwh
 * @create 2024-12-03 16:42
 */
@Service
@Slf4j
public class AdminStateServiceImpl implements AdminStateService {

    @Autowired
    private StateMapper stateMapper;

    @Override
    public Response addState(AddStateReqVO addStateReqVO) {
        String stateName = addStateReqVO.getStateName();
        StateDO stateDO = stateMapper.selectByName(stateName);

        if (Objects.nonNull(stateDO)) {
            log.warn("状态名称： {}, 此状态已存在", stateName);
            throw new BizException(ResponseCodeEnum.STATE_NAME_IS_EXISTED);
        }

        // 构建 DO 类
        StateDO insertStateDO = StateDO.builder()
                .stateName(addStateReqVO.getStateName().trim())
                .build();

        // 执行 insert
        stateMapper.insert(insertStateDO);

        return Response.success();
    }

    @Override
    public PageResponse findStateList(FindStatePageListReqVO findStatePageListReqVO) {
        // 获取当前页、以及每页需要展示的数据数量
        Long current = findStatePageListReqVO.getCurrent();
        Long size = findStatePageListReqVO.getSize();

        // 分页对象(查询第几页、每页多少数据)
        Page<StateDO> page = new Page<>(current, size);

        // 构建查询条件
        LambdaQueryWrapper<StateDO> wrapper = new LambdaQueryWrapper<>();

        String stateName = findStatePageListReqVO.getStateName();
        LocalDate startDate = findStatePageListReqVO.getStartDate();
        LocalDate endDate = findStatePageListReqVO.getEndDate();

        wrapper
                .like(StringUtils.isNotBlank(stateName), StateDO::getStateName, stateName.trim()) // like 模块查询
                .ge(Objects.nonNull(startDate), StateDO::getCreateTime, startDate) // 大于等于 startDate
                .le(Objects.nonNull(endDate), StateDO::getCreateTime, endDate)  // 小于等于 endDate
                .orderByDesc(StateDO::getCreateTime); // 按创建时间倒叙

        // 执行分页查询
        Page<StateDO> stateDOPage = stateMapper.selectPage(page, wrapper);

        List<StateDO> stateDOS = stateDOPage.getRecords();

        // DO 转 VO
        List<FindStatePageListRspVO> vos = null;
        if (!CollectionUtils.isEmpty(stateDOS)) {
            vos = stateDOS.stream()
                    .map(stateDO -> FindStatePageListRspVO.builder()
                            .id(stateDO.getId())
                            .stateName(stateDO.getStateName())
                            .createTime(stateDO.getCreateTime())
                            .build())
                    .collect(Collectors.toList());
        }

        return PageResponse.success(stateDOPage, vos);
    }

    @Override
    public Response deleteState(DeleteStateReqVO deleteStateReqVO) {
        Long id = deleteStateReqVO.getId();
        stateMapper.deleteById(id);
        return Response.success();
    }
}
