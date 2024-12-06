package com.jiaotangbing.wms.common.domain.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiaotangbing.wms.common.domain.dos.MaterialDO;
import com.jiaotangbing.wms.common.domain.dos.StateDO;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author lwh
 * @create 2024-11-26 21:20
 */
public interface MaterialMapper extends BaseMapper<MaterialDO> {

    /**
     * 根据材料名查询
     * @param current
     * @param size
     * @param materialName
     * @return
     */
    default Page<MaterialDO> selectPageListByMaterialName(Long current, Long size, String materialName) {
        // 分页对象(查询第几页、每页多少数据)
        Page<MaterialDO> page = new Page<>(current, size);

        // 构建查询条件
        LambdaQueryWrapper<MaterialDO> wrapper = Wrappers.<MaterialDO>lambdaQuery()
                .like(StringUtils.isNotBlank(materialName), MaterialDO::getMaterialName, materialName.trim()); // like 模块查询

        return selectPage(page, wrapper);
    }
}
