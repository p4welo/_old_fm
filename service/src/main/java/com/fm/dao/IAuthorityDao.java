package com.fm.dao;

import com.fm.domain.Authority;
import com.fm.domain.UserEntity;

import java.util.List;

/**
 * UserEntity: pawel
 * Date: 17.12.12
 * Time: 19:39
 */
public interface IAuthorityDao
{
   List<Authority> getAuthoritiesByUser(UserEntity userEntity);
}
