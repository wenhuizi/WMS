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

}
