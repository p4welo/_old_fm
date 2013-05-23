package com.fm.dao;

import com.fm.domain.User;

/**
 * User: pawel
 * Date: 17.12.12
 * Time: 19:31
 */
public interface IUserDao extends IAbstractDao<User>
{
   User findByLogin(String login);

//   User authenticate(String login, String password);
}
