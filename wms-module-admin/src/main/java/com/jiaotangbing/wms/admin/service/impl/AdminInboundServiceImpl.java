package com.jiaotangbing.wms.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiaotangbing.wms.admin.model.vo.inbound.AddInboundReqVO;
import com.jiaotangbing.wms.admin.model.vo.inbound.DeleteInboundReqVO;
import com.jiaotangbing.wms.admin.model.vo.inbound.UpdateInboundReqVO;
import com.jiaotangbing.wms.admin.service.AdminInboundService;
import com.jiaotangbing.wms.common.domain.dos.InboundDO;
import com.jiaotangbing.wms.common.domain.mapper.InboundMapper;
import com.jiaotangbing.wms.common.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
