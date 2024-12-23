package com.jiaotangbing.wms.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiaotangbing.wms.admin.model.vo.inbound.UpdateInboundReqVO;
import com.jiaotangbing.wms.admin.model.vo.materialCategory.*;
import com.jiaotangbing.wms.admin.service.AdminMaterialCategoryService;
import com.jiaotangbing.wms.common.domain.dos.MaterialCategoryDO;
import com.jiaotangbing.wms.common.domain.mapper.MaterialCategoryMapper;
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
 * @create 2024-12-04 16:17
 */
@Service
@Slf4j
public class AdminMaterialCategoryServiceImpl extends ServiceImpl<MaterialCategoryMapper, MaterialCategoryDO> implements AdminMaterialCategoryService {

    @Autowired
    private MaterialCategoryMapper materialCategoryMapper;

    @Override
    public Response addMaterialCategory(AddMaterialCategoryReqVO addMaterialCategoryReqVO) {
        String categoryName = addMaterialCategoryReqVO.getCategoryName();
        MaterialCategoryDO materialCategoryDO = materialCategoryMapper.selectByName(categoryName);

        if (Objects.nonNull(materialCategoryDO)) {
            log.warn("大类名称： {}, 此大类已存在", categoryName);
            throw new BizException(ResponseCodeEnum.CATEGORY_NAME_IS_EXISTED);
        }

        // 构建 DO 类
        MaterialCategoryDO insertCategoryDO = MaterialCategoryDO.builder()
                .categoryName(addMaterialCategoryReqVO.getCategoryName().trim())
                .specs(addMaterialCategoryReqVO.getSpecs())
                .storeNum(addMaterialCategoryReqVO.getStoreNum())
                .build();

        // 执行 insert
        materialCategoryMapper.insert(insertCategoryDO);

        return Response.success();
    }

    @Override
    public PageResponse findMaterialCategoryList(FindMaterialCategoryPageListReqVO findMaterialCategoryPageListReqVO) {
        // 获取当前页、以及每页需要展示的数据数量
        Long current = findMaterialCategoryPageListReqVO.getCurrent();
        Long size = findMaterialCategoryPageListReqVO.getSize();

        // 分页对象(查询第几页、每页多少数据)
        Page<MaterialCategoryDO> page = new Page<>(current, size);

        LambdaQueryWrapper<MaterialCategoryDO> wrapper = new LambdaQueryWrapper<>();
        String categoryName = findMaterialCategoryPageListReqVO.getCategoryName();
        LocalDate startDate = findMaterialCategoryPageListReqVO.getStartDate();
        LocalDate endDate = findMaterialCategoryPageListReqVO.getEndDate();

        wrapper
                .like(StringUtils.isNotBlank(categoryName), MaterialCategoryDO::getCategoryName, categoryName.trim()) // like 模块查询
                .ge(Objects.nonNull(startDate), MaterialCategoryDO::getCreateTime, startDate) // 大于等于 startDate
                .le(Objects.nonNull(endDate), MaterialCategoryDO::getCreateTime, endDate)  // 小于等于 endDate
                .orderByDesc(MaterialCategoryDO::getCreateTime); // 按创建时间倒叙

        Page<MaterialCategoryDO> materialCategoryDOPage = materialCategoryMapper.selectPage(page, wrapper);
        List<MaterialCategoryDO> materialCategoryDOS = materialCategoryDOPage.getRecords();

        // DO 转 VO
        List<FindMaterialCategoryPageListRspVO> vos = null;
        if (!CollectionUtils.isEmpty(materialCategoryDOS)) {
            vos = materialCategoryDOS.stream()
                    .map(materialCategoryDO -> FindMaterialCategoryPageListRspVO.builder()
                            .id(materialCategoryDO.getId())
                            .categoryName(materialCategoryDO.getCategoryName())
                            .specs(materialCategoryDO.getSpecs())
                            .storeNum(materialCategoryDO.getStoreNum())
                            .createTime(materialCategoryDO.getCreateTime())
                            .build())
                    .collect(Collectors.toList());
        }

        return PageResponse.success(materialCategoryDOPage, vos);
    }

    @Override
    public Response deleteMaterialCategory(DeleteMaterialCategoryReqVO deleteMaterialCategoryReqVO) {
        Long id = deleteMaterialCategoryReqVO.getId();
        materialCategoryMapper.deleteById(id);
        return Response.success();
    }

    @Override
    public Response updateMaterialCategory(UpdateMaterialCategoryReqVO updateMaterialCategoryReqVO) {
        MaterialCategoryDO materialCategoryDO = MaterialCategoryDO.builder()
                .id(1L)
                .categoryName(updateMaterialCategoryReqVO.getCategoryName())
                .specs(updateMaterialCategoryReqVO.getSpecs())
                .storeNum(updateMaterialCategoryReqVO.getStoreNum())
                .build();
        saveOrUpdate(materialCategoryDO);
        return Response.success();
    }
}
