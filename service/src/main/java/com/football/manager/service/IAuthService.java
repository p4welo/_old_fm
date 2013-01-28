package com.football.manager.service;

import com.football.manager.domain.UserEntity;

/**
 * User: pawel
 * Date: 20.12.12
 * Time: 23:19
 */
public interface IAuthService
{
   UserEntity getLoggedInUserEntity();

   boolean hasAuthority(String role);
}
