package com.fm.dao;

import com.fm.domain.Authority;
import com.fm.domain.User;

import java.util.List;

/**
 * User: pawel
 * Date: 17.12.12
 * Time: 19:39
 */
public interface IAuthorityDao
{
   List<Authority> getAuthoritiesByUser(User user);
}
