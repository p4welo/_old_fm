package com.fm.service.impl;

import com.fm.domain.Authority;
import com.fm.domain.UserEntity;
import com.fm.service.IAssemblerService;
import com.fm.service.IAuthorityService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * UserEntity: pawel
 * Date: 17.12.12
 * Time: 19:20
 */
@Service(AssemblerServiceImpl.BEAN_NAME)
public class AssemblerServiceImpl implements IAssemblerService
{
   public static final String BEAN_NAME = "assemblerService";

   @Resource
   private IAuthorityService authorityService;

   @Transactional
   public User buildUserFromUserEntity(UserEntity userEntity)
   {
      String username = userEntity.getLogin();
      String password = userEntity.getPassword();
      boolean enabled = true;//userEntity.getActive();
      boolean accountNonExpired = true;//userEntity.getActive();
      boolean credentialsNonExpired = true;//userEntity.getActive();
      boolean accountNonLocked = true;//userEntity.getActive();

      Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
      List<Authority> userAuthorities = authorityService.getUserAuthorities(userEntity);
      for (Authority authority : userAuthorities)
      {
         grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
      }

      User user = new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
              grantedAuthorities);

      return user;
   }
}
