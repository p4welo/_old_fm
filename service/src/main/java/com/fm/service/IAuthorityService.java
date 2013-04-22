package com.fm.service;

import com.fm.domain.Authority;
import com.fm.domain.User;

import java.util.List;

/**
 * User: pawel
 * Date: 17.12.12
 * Time: 19:40
 */
public interface IAuthorityService extends IAbstractService<Authority>
{
   List<Authority> getUserAuthorities(User user);

   List<String> getAuthorities(User user);

   Authority addUserAuthority(User user, String role_user);
}
