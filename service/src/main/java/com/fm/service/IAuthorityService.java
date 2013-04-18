package com.fm.service;

import com.fm.domain.Authority;
import com.fm.domain.UserEntity;

import java.util.List;

/**
 * UserEntity: pawel
 * Date: 17.12.12
 * Time: 19:40
 */
public interface IAuthorityService extends IAbstractService<Authority>
{
   List<Authority> getUserAuthorities(UserEntity userEntity);

   List<String> getAuthorities(UserEntity user);
}
