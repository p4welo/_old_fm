package com.fm.service;

import com.fm.domain.User;

/**
 * User: pawel
 * Date: 17.12.12
 * Time: 19:28
 */
public interface IUserService extends IAbstractService<User>
{
   User getByLogin(String login);

   User changePassword(User user, String password);

   User registerUser(User user);

   User getByEmail(String email);
}
