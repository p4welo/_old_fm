package com.football.manager.dao;

import com.football.manager.domain.UserEntity;

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
