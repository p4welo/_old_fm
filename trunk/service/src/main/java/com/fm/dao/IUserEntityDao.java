package com.fm.dao;

import com.fm.domain.UserEntity;

/**
 * UserEntity: pawel
 * Date: 17.12.12
 * Time: 19:31
 */
public interface IUserEntityDao
{
   UserEntity findByLogin(String login);

   UserEntity authenticate(String login, String password);
}
