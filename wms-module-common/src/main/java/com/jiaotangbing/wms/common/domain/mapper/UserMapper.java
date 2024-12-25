package com.jiaotangbing.wms.common.domain.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiaotangbing.wms.common.domain.dos.UserDO;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author lwh
 * @create 2024-11-12 23:18
 */
public interface UserMapper extends BaseMapper<UserDO> {
    default UserDO findByUsername(String username) {
        LambdaQueryWrapper<UserDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserDO::getUsername, username);
        return selectOne(wrapper);
    }

    default int updateByUsername(String username, String password, Integer telephone) {
        LambdaUpdateWrapper<UserDO> wrapper = new LambdaUpdateWrapper<>();
        // 设置要更新的字段
        wrapper.set(UserDO::getPassword, password);
        wrapper.set(UserDO::getUpdateTime, LocalDateTime.now());
        wrapper.set(UserDO::getTelephone, telephone);
        // 更新条件
        wrapper.eq(UserDO::getUsername, username);

        return update(null, wrapper);
    }

    default Page<UserDO> selectPageList(Long current, Long size, String userName, Integer telephone) {
        // 分页对象(查询第几页、每页多少数据)
        Page<UserDO> page = new Page<>(current, size);

        // 构建查询条件
        LambdaQueryWrapper<UserDO> wrapper = Wrappers.<UserDO>lambdaQuery()
                .like(StringUtils.isNotBlank(userName), UserDO::getUsername, userName) // like 模块查询
                .like(Objects.nonNull(telephone), UserDO::getTelephone,telephone);

        return selectPage(page, wrapper);
    }

}

