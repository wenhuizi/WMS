package com.jiaotangbing.wms.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiaotangbing.wms.admin.model.vo.inbound.*;
import com.jiaotangbing.wms.admin.service.AdminInboundService;
import com.jiaotangbing.wms.common.domain.dos.InboundDO;
import com.jiaotangbing.wms.common.domain.mapper.InboundMapper;
import com.jiaotangbing.wms.common.utils.PageResponse;
import com.jiaotangbing.wms.common.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author lwh
 * @create 2024-12-08 20:05
 */
@Service
@Slf4j
public class AdminInboundServiceImpl extends ServiceImpl<InboundMapper, InboundDO> implements AdminInboundService {

    @Autowired
    private InboundMapper inboundMapper;

    @Override
    public Response addInbounnd(AddInboundReqVO addInboundReqVO) {
        InboundDO inboundDO = InboundDO.builder()
                .categoryName(addInboundReqVO.getCategoryName())
                .materialName(addInboundReqVO.getMaterialName())
                .inboundNum(addInboundReqVO.getInboundNum())
                .provider(addInboundReqVO.getProvider())
                .attn(addInboundReqVO.getAttn())
                .contractNo(addInboundReqVO.getContractNo())
                .notes(addInboundReqVO.getNotes())
                .inboundTime(LocalDateTime.now())
                .build();
        inboundMapper.insert(inboundDO);
        return Response.success();
    }

    @Override
    public Response updateInbound(UpdateInboundReqVO updateInboundReqVO) {
        InboundDO inboundDO = InboundDO.builder()
                .id(1L)
                .categoryName(updateInboundReqVO.getCategoryName())
                .materialName(updateInboundReqVO.getMaterialName())
                .inboundNum(updateInboundReqVO.getInboundNum())
                .provider(updateInboundReqVO.getProvider())
                .attn(updateInboundReqVO.getAttn())
                .contractNo(updateInboundReqVO.getContractNo())
                .notes(updateInboundReqVO.getNotes())
                .build();
        saveOrUpdate(inboundDO);
        return Response.success();
    }

    @Override
    public Response deleteInbound(DeleteInboundReqVO deleteInboundReqVO) {
        Long id = deleteInboundReqVO.getId();
        inboundMapper.deleteById(id);
        return Response.success();
    }

    @Override
    public PageResponse findInboundList(FindInboundPageListReqVO findInboundPageListReqVO) {
        // 获取当前页、以及每页需要展示的数据数量
        Long current = findInboundPageListReqVO.getCurrent();
        Long size = findInboundPageListReqVO.getSize();
        // 分页对象(查询第几页、每页多少数据)
        Page<InboundDO> page = new Page<>(current, size);
        LambdaQueryWrapper<InboundDO> wrapper = new LambdaQueryWrapper<>();
        String categoryName = findInboundPageListReqVO.getCategoryName();
        String materialName = findInboundPageListReqVO.getMaterialName();
        String provider = findInboundPageListReqVO.getProvider();
        String attn = findInboundPageListReqVO.getAttn();
        String contractNo = findInboundPageListReqVO.getContractNo();
        LocalDate startDate = findInboundPageListReqVO.getStartDate();
        LocalDate endDate = findInboundPageListReqVO.getEndDate();

        wrapper
                .like(StringUtils.isNotBlank(categoryName), InboundDO::getCategoryName, categoryName.trim()) // like 模块查询
                .like(StringUtils.isNotBlank(materialName), InboundDO::getMaterialName, materialName.trim())
                .like(StringUtils.isNotBlank(provider), InboundDO::getProvider, provider.trim())
                .like(StringUtils.isNotBlank(attn), InboundDO::getAttn, attn.trim())
                .like(StringUtils.isNotBlank(contractNo), InboundDO::getContractNo, contractNo.trim())
                .ge(Objects.nonNull(startDate), InboundDO::getInboundTime, startDate) // 大于等于 startDate
                .le(Objects.nonNull(endDate), InboundDO::getInboundTime, endDate)  // 小于等于 endDate
                .orderByDesc(InboundDO::getInboundTime); // 按创建时间倒叙

        // 执行分页查询
        Page<InboundDO> inboundDOPage = inboundMapper.selectPage(page, wrapper);

        List<InboundDO> inboundDOS = inboundDOPage.getRecords();

        // DO 转 VO
        List<FindInboundPageListRspVO> vos = null;
        if (!CollectionUtils.isEmpty(inboundDOS)) {
            vos = inboundDOS.stream()
                    .map(inboundDO -> FindInboundPageListRspVO.builder()
                            .id(inboundDO.getId())
                            .categoryName(inboundDO.getCategoryName())
                            .materialName(inboundDO.getMaterialName())
                            .inboundNum(inboundDO.getInboundNum())
                            .provider(inboundDO.getProvider())
                            .attn(inboundDO.getAttn())
                            .contractNo(inboundDO.getContractNo())
                            .inboundTime(inboundDO.getInboundTime())
                            .notes(inboundDO.getNotes())
                            .build())
                    .collect(Collectors.toList());
        }

        return PageResponse.success(inboundDOPage, vos);
    }
}

