package com.fm.service;

import com.fm.domain.UserEntity;

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
