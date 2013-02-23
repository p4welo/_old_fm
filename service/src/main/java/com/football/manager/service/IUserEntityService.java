package com.football.manager.service;

import com.football.manager.domain.UserEntity;

/**
 * UserEntity: pawel
 * Date: 17.12.12
 * Time: 19:28
 */
public interface IUserEntityService extends IAbstractService<UserEntity>
{
   UserEntity findByLogin(String login);

   boolean authenticate(String login, String password);
}
