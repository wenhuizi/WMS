package com.jiaotangbing.wms.common.domain.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiaotangbing.wms.common.domain.dos.UserDO;
import com.jiaotangbing.wms.common.domain.dos.UserRoleDO;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * @author lwh
 * @create 2024-11-13 16:03
 */
public interface UserRoleMapper extends BaseMapper<UserRoleDO> {

    /**
     * 根据用户名查询(List)
     * @param username
     * @return
     */
    default List<UserRoleDO> selectByUsername(String username) {
        LambdaQueryWrapper<UserRoleDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserRoleDO::getUsername, username);

        return selectList(wrapper);
    }


    /**
     * 根据用户名查询(One)
     * @param username
     * @return
     */
    default UserRoleDO selectByUsernameOne(String username) {
        LambdaQueryWrapper<UserRoleDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserRoleDO::getUsername, username);

        return selectOne(wrapper);
    }

    /**
     * 根据角色查询(List)
     * @param role
     * @return
     */
    default List<UserRoleDO> selectByRoleList(String role) {
        LambdaQueryWrapper<UserRoleDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserRoleDO::getRole, role);

        return selectList(wrapper);
    }

    /**
     * 根据角色查询(One)
     * @param role
     * @return
     */
    default UserRoleDO selectByRole(String role) {
        LambdaQueryWrapper<UserRoleDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserRoleDO::getRole, role);

        return selectOne(wrapper);
    }
}
