package com.jiaotangbing.wms.common.domain.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiaotangbing.wms.common.domain.dos.MaterialCategoryDO;
import com.jiaotangbing.wms.common.domain.dos.StateDO;

/**
 * @author lwh
 * @create 2024-11-25 11:48
 */
public interface MaterialCategoryMapper extends BaseMapper<MaterialCategoryDO> {

    /**
     * 根据大类名查询
     * @param categoryName
     * @return
     */
    default MaterialCategoryDO selectByName(String categoryName) {
        LambdaQueryWrapper<MaterialCategoryDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MaterialCategoryDO::getCategoryName, categoryName);
        return selectOne(wrapper);
    }
}
