package com.fm.service;

import com.fm.domain.User;

/**
 * User: pawel
 * Date: 20.12.12
 * Time: 23:19
 */
public interface IAuthService
{
   User getLoggedInUserEntity();

   boolean hasAuthority(String role);
}
