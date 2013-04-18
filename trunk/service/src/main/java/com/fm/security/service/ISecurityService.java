package com.fm.security.service;

import com.fm.domain.User;

public interface ISecurityService
{
   User getLoggedInUser();

   boolean hasRole(String... roles);
}
