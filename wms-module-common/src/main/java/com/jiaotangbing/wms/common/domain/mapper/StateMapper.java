package com.jiaotangbing.wms.common.domain.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiaotangbing.wms.common.domain.dos.StateDO;

/**
 * @author lwh
 * @create 2024-11-25 12:18
 */
public interface StateMapper extends BaseMapper<StateDO> {

    /**
     * 根据状态名查询
     * @param stateName
     * @return
     */
    default StateDO selectByName(String stateName) {
        LambdaQueryWrapper<StateDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StateDO::getStateName, stateName);
        return selectOne(wrapper);
    }
}
