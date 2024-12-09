package com.jiaotangbing.wms.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiaotangbing.wms.admin.model.vo.outbound.*;
import com.jiaotangbing.wms.admin.service.AdminOutboundService;
import com.jiaotangbing.wms.common.domain.dos.OutboundDO;
import com.jiaotangbing.wms.common.domain.mapper.OutboundMapper;
import com.jiaotangbing.wms.common.utils.PageResponse;
import com.jiaotangbing.wms.common.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author lwh
 * @create 2024-12-09 11:41
 */
@Service
@Slf4j
public class AdminOutboundServiceImpl  extends ServiceImpl<OutboundMapper, OutboundDO> implements AdminOutboundService {

    @Autowired
    private OutboundMapper outboundMapper;

    @Override
    public Response addOutbounnd(AddOutboundReqVO addOutboundReqVO) {
        OutboundDO outboundDO = OutboundDO.builder()
                .categoryName(addOutboundReqVO.getCategoryName())
                .materialName(addOutboundReqVO.getMaterialName())
                .outboundNum(addOutboundReqVO.getOutboundNum())
                .provider(addOutboundReqVO.getProvider())
                .attn(addOutboundReqVO.getAttn())
                .contractNo(addOutboundReqVO.getContractNo())
                .notes(addOutboundReqVO.getNotes())
                .build();
        outboundMapper.insert(outboundDO);
        return Response.success();
    }

    @Override
    public Response updateOutbound(UpdateOutboundReqVO updateOutboundReqVO) {
        OutboundDO outboundDO = OutboundDO.builder()
                .id(1L)
                .categoryName(updateOutboundReqVO.getCategoryName())
                .materialName(updateOutboundReqVO.getMaterialName())
                .outboundNum(updateOutboundReqVO.getOutboundNum())
                .provider(updateOutboundReqVO.getProvider())
                .attn(updateOutboundReqVO.getAttn())
                .contractNo(updateOutboundReqVO.getContractNo())
                .notes(updateOutboundReqVO.getNotes())
                .build();
        saveOrUpdate(outboundDO);
        return Response.success();
    }

    @Override
    public Response deleteOutbound(DeleteOutboundReqVO deleteOutboundReqVO) {
        Long id = deleteOutboundReqVO.getId();
        outboundMapper.deleteById(id);
        return Response.success();
    }

    @Override
    public PageResponse findOutboundList(FindOutboundPageListReqVO findOutboundPageListReqVO) {
        // 获取当前页、以及每页需要展示的数据数量
        Long current = findOutboundPageListReqVO.getCurrent();
        Long size = findOutboundPageListReqVO.getSize();
        // 分页对象(查询第几页、每页多少数据)
        Page<OutboundDO> page = new Page<>(current, size);
        LambdaQueryWrapper<OutboundDO> wrapper = new LambdaQueryWrapper<>();
        String categoryName = findOutboundPageListReqVO.getCategoryName();
        String materialName = findOutboundPageListReqVO.getMaterialName();
        String provider = findOutboundPageListReqVO.getProvider();
        String attn = findOutboundPageListReqVO.getAttn();
        String contractNo = findOutboundPageListReqVO.getContractNo();
        LocalDate startDate = findOutboundPageListReqVO.getStartDate();
        LocalDate endDate = findOutboundPageListReqVO.getEndDate();

        wrapper
                .like(StringUtils.isNotBlank(categoryName), OutboundDO::getCategoryName, categoryName.trim()) // like 模块查询
                .like(StringUtils.isNotBlank(materialName), OutboundDO::getMaterialName, materialName.trim())
                .like(StringUtils.isNotBlank(provider), OutboundDO::getProvider, provider.trim())
                .like(StringUtils.isNotBlank(attn), OutboundDO::getAttn, attn.trim())
                .like(StringUtils.isNotBlank(contractNo), OutboundDO::getContractNo, contractNo.trim())
                .ge(Objects.nonNull(startDate), OutboundDO::getOutboundTime, startDate) // 大于等于 startDate
                .le(Objects.nonNull(endDate), OutboundDO::getOutboundTime, endDate)  // 小于等于 endDate
                .orderByDesc(OutboundDO::getOutboundTime); // 按创建时间倒叙

        // 执行分页查询
        Page<OutboundDO> outboundDOPage = outboundMapper.selectPage(page, wrapper);

        List<OutboundDO> outboundDOS = outboundDOPage.getRecords();

        // DO 转 VO
        List<FindOutboundPageListRspVO> vos = null;
        if (!CollectionUtils.isEmpty(outboundDOS)) {
            vos = outboundDOS.stream()
                    .map(outboundDO -> FindOutboundPageListRspVO.builder()
                            .id(outboundDO.getId())
                            .categoryName(outboundDO.getCategoryName())
                            .materialName(outboundDO.getMaterialName())
                            .outboundNum(outboundDO.getOutboundNum())
                            .provider(outboundDO.getProvider())
                            .attn(outboundDO.getAttn())
                            .contractNo(outboundDO.getContractNo())
                            .outboundTime(outboundDO.getOutboundTime())
                            .build())
                    .collect(Collectors.toList());
        }

        return PageResponse.success(outboundDOPage, vos);
    }
}
