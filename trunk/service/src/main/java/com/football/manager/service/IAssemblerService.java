package com.football.manager.service;

import com.football.manager.domain.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * UserEntity: pawel
 * Date: 17.12.12
 * Time: 19:20
 */
public interface IAssemblerService
{
   UserDetails buildUserFromUserEntity(UserEntity userEntity);
}
