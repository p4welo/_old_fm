package com.fm.service.impl;

import com.fm.dao.IUserDao;
import com.fm.domain.User;
import com.fm.service.IAssemblerService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * User: pawel
 * Date: 17.12.12
 * Time: 19:15
 */
@Service(UserDetailServiceImpl.BEAN_NAME)
public class UserDetailServiceImpl implements UserDetailsService
{
   public static final String BEAN_NAME = "userDetailService";

   @Resource
   private IUserDao userDao;

   @Resource
   private IAssemblerService assemblerService;

   @Transactional(readOnly = true)
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
   {
      User user = userDao.findByLogin(username);
      if (user == null)
      {
         throw new UsernameNotFoundException("user not found");
      }

      return assemblerService.buildUserFromUserEntity(user);
   }
}
