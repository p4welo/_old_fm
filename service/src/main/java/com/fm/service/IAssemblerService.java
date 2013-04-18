package com.fm.service;

import com.fm.domain.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * User: pawel
 * Date: 17.12.12
 * Time: 19:20
 */
public interface IAssemblerService
{
   UserDetails buildUserFromUserEntity(User user);
}
