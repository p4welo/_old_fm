package com.fm.service.impl;

import com.fm.domain.UserEntity;
import com.fm.domain.UserRole;
import com.fm.service.IAssemblerService;
import com.fm.service.IUserRoleService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
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
   private IUserRoleService userRoleService;

   @Transactional
   public User buildUserFromUserEntity(UserEntity userEntity)
   {

      String username = userEntity.getLogin();
      String password = userEntity.getPassword();
      boolean enabled = true;//userEntity.getActive();
      boolean accountNonExpired = true;//userEntity.getActive();
      boolean credentialsNonExpired = true;//userEntity.getActive();
      boolean accountNonLocked = true;//userEntity.getActive();
      Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
      List<UserRole> userRoleEntities = userRoleService.getUserRoles(userEntity);

      for (int i = 0; i < userRoleEntities.size(); i++)
      {
         authorities.add(new GrantedAuthorityImpl(userRoleEntities.get(i).getRole()));
      }

      User user = new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
              authorities);

      return user;
   }
}
