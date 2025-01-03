package com.jiaotangbing.wms.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiaotangbing.wms.admin.model.vo.material.*;
import com.jiaotangbing.wms.admin.service.AdminMaterialService;
import com.jiaotangbing.wms.common.domain.dos.InboundDO;
import com.jiaotangbing.wms.common.domain.dos.MaterialCategoryDO;
import com.jiaotangbing.wms.common.domain.dos.MaterialDO;
import com.jiaotangbing.wms.common.domain.mapper.MaterialCategoryMapper;
import com.jiaotangbing.wms.common.domain.mapper.MaterialMapper;
import com.jiaotangbing.wms.common.enums.ResponseCodeEnum;
import com.jiaotangbing.wms.common.exception.BizException;
import com.jiaotangbing.wms.common.utils.PageResponse;
import com.jiaotangbing.wms.common.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author lwh
 * @create 2024-12-06 9:56
 */
@Service
@Slf4j
public class AdminMaterialServiceImpl extends ServiceImpl<MaterialMapper, MaterialDO> implements AdminMaterialService {

    @Autowired
    private MaterialMapper materialMapper;
    @Autowired
    private MaterialCategoryMapper materialCategoryMapper;

    @Override
    public Response addMaterial(AddMaterialReqVO addMaterialReqVO) {
        String categoryName = addMaterialReqVO.getCategoryName();
        MaterialCategoryDO materialCategoryDO = materialCategoryMapper.selectByName(categoryName);
        if(Objects.isNull(materialCategoryDO)){
            log.warn("此大类不存在，请先添加大类", categoryName);
            throw new BizException(ResponseCodeEnum.CATEGORY_NAME_IS_NOT_EXISTED);
        }

        MaterialDO materialDO = MaterialDO.builder()
                .materialName(addMaterialReqVO.getMaterialName())
                .categoryName(addMaterialReqVO.getCategoryName())
                .specs(addMaterialReqVO.getSpecs())
                .grammage(addMaterialReqVO.getGrammage())
                .width(addMaterialReqVO.getWidth())
                .intensity(addMaterialReqVO.getIntensity())
                .storeNum(addMaterialReqVO.getStoreNum())
                .provider(addMaterialReqVO.getProvider().trim())
                .build();
        materialMapper.insert(materialDO);
        return Response.success();
    }

    @Override
    public Response updateMaterial(UpdateMaterialReqVO updateMaterialReqVO) {
        MaterialDO materialDO = MaterialDO.builder()
                .id(1L)
                .materialName(updateMaterialReqVO.getMaterialName())
                .categoryName(updateMaterialReqVO.getCategoryName())
                .specs(updateMaterialReqVO.getSpecs())
                .grammage(updateMaterialReqVO.getGrammage())
                .width(updateMaterialReqVO.getWidth())
                .intensity(updateMaterialReqVO.getIntensity())
                .unit(updateMaterialReqVO.getUnit())
                .storeNum(updateMaterialReqVO.getStoreNum())
                .provider(updateMaterialReqVO.getProvider())
                .build();
        // 保存或更新（当数据库中存在 ID 为 1 的记录时，则执行更新操作，否则执行插入操作）
        saveOrUpdate(materialDO);
        return Response.success();
    }

    @Override
    public Response deleteMaterial(DeleteMaterialReqVO deleteMaterialReqVO) {
        Long id = deleteMaterialReqVO.getId();
        materialMapper.deleteById(id);
        return Response.success();
    }

    @Override
    public Response findMaterialPageList(FindMaterialPageListReqVO findMaterialPageListReqVO) {
        String materialName = findMaterialPageListReqVO.getMaterialName();
        String categoryName = findMaterialPageListReqVO.getCategoryName();
        String provider = findMaterialPageListReqVO.getProvider();
        Long current = findMaterialPageListReqVO.getCurrent();
        Long size = findMaterialPageListReqVO.getSize();

        // 分页对象(查询第几页、每页多少数据)
        Page<MaterialDO> page = new Page<>(current, size);

        // 构建查询条件
        LambdaQueryWrapper<MaterialDO> wrapper = new LambdaQueryWrapper<>();

        wrapper
                .like(StringUtils.isNotBlank(materialName), MaterialDO::getMaterialName, materialName.trim())
                .like(StringUtils.isNotBlank(categoryName), MaterialDO::getCategoryName, categoryName.trim())
                .like(StringUtils.isNotBlank(provider), MaterialDO::getProvider, provider.trim());
        // 执行分页查询
        Page<MaterialDO> materialDOPage = materialMapper.selectPage(page, wrapper);

        List<MaterialDO> materialDOS = materialDOPage.getRecords();


        // DO 转 VO
        List<FindMaterialPageListRspVO> vos = null;
        if (!CollectionUtils.isEmpty(materialDOS)) {
            vos = materialDOS.stream()
                    .map(materialDO -> FindMaterialPageListRspVO.builder()
                            .id(materialDO.getId())
                            .materialName(materialDO.getMaterialName())
                            .categoryName(materialDO.getCategoryName())
                            .provider(materialDO.getProvider())
                            .build())
                    .collect(Collectors.toList());
        }

        return PageResponse.success(materialDOPage, vos);
    }

}
