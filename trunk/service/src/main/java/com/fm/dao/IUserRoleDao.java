package com.fm.dao;

import com.fm.domain.UserEntity;
import com.fm.domain.UserRole;

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
