package com.football.manager.security.service;

import com.football.manager.domain.UserEntity;

public interface ISecurityService
{
   UserEntity getLoggedInUser();

   boolean hasRole(String... roles);
}
