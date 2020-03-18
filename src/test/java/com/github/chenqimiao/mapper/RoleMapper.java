package com.github.chenqimiao.mapper;

import com.github.chenqimiao.domain.Role;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/18 17:15
 * @Description:
 */
public interface RoleMapper {
   Role getRole(Long id);
   Role findRole(String roleName);
   int deleteRole(Long id);
   int insertRole(Role role);
}
