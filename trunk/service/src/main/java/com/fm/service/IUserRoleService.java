package com.fm.service;

import com.fm.domain.UserEntity;
import com.fm.domain.UserRole;

import java.util.List;

/**
 * UserEntity: pawel
 * Date: 17.12.12
 * Time: 19:40
 */
public interface IUserRoleService extends IAbstractService<UserRole>
{
   List<UserRole> getUserRoles(UserEntity userEntity);

   List<String> getRoles(UserEntity user);
}
