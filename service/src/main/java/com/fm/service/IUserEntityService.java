package com.fm.service;

import com.fm.domain.UserEntity;

/**
 * UserEntity: pawel
 * Date: 17.12.12
 * Time: 19:28
 */
public interface IUserEntityService extends IAbstractService<UserEntity>
{
   UserEntity getByLogin(String login);

   boolean authenticate(String login, String password);
}
