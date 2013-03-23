package com.fm.security;

import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.userdetails.UserDetails;

public class UserSaltSource implements SaltSource
{
   @Override
   public Object getSalt(UserDetails user)
   {
      return user.getUsername();
   }
}
