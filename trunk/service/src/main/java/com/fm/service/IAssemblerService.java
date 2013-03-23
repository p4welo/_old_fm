package com.fm.service;

import com.fm.domain.UserEntity;
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
