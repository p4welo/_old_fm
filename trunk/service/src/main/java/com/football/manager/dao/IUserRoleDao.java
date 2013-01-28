package com.football.manager.dao;

import com.football.manager.domain.UserEntity;
import com.football.manager.domain.UserRole;

import java.util.List;

/**
 * UserEntity: pawel
 * Date: 17.12.12
 * Time: 19:39
 */
public interface IUserRoleDao
{
   List<UserRole> getRolesByUser(UserEntity userEntity);
}
