package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.IAuthorityDao;
import com.fm.domain.Authority;
import com.fm.domain.ObjectStateEnum;
import com.fm.domain.User;
import com.fm.service.IAuthorityService;
import com.fm.service.util.SidUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * User: pawel
 * Date: 17.12.12
 * Time: 19:41
 */
@Service(AuthorityServiceImpl.BEAN_NAME)
public class AuthorityServiceImpl extends AbstractServiceImpl<Authority> implements IAuthorityService
{
   public static final String BEAN_NAME = "authorityService";

   @Resource
   private IAuthorityDao authorityDao;

   @Override
   protected IAbstractDao<Authority> getDao()
   {
      return authorityDao;
   }

   @Override
   @Transactional
   public List<Authority> getUserAuthorities(User user)
   {
      return authorityDao.getAuthoritiesByUser(user);
   }

   @Override
   @Transactional
   public List<String> getAuthorities(User user)
   {
      List<String> roles = new ArrayList<String>();
      List<Authority> authorities = authorityDao.getAuthoritiesByUser(user);
      if (authorities != null)
      {
         for (Authority userRole : authorities)
         {
            roles.add(userRole.getAuthority());
         }
      }
      return roles;
   }

   @Override
   public Authority addUserAuthority(User user, String role_user)
   {
      Authority authority = new Authority();
      authority.setUser(user);
      authority.setAuthority("ROLE_USER");
      authority.setObjectState(ObjectStateEnum.ACTIVE);
      authority.setSid(SidUtils.generate());
      return getDao().save(authority);
   }
}
