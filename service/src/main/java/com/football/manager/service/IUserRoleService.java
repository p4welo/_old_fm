package com.football.manager.service;

import com.football.manager.domain.UserEntity;
import com.football.manager.domain.UserRole;

import java.util.List;

/**
 * UserEntity: pawel
 * Date: 17.12.12
 * Time: 19:40
 */
public interface IUserRoleService extends IAbstractService<UserRole>
{
   List<UserRole> getUserRoles(UserEntity userEntity);
}
