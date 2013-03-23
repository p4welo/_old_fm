package com.fm.security.service;

import com.fm.domain.UserEntity;

public interface ISecurityService
{
   UserEntity getLoggedInUser();

   boolean hasRole(String... roles);
}
