package com.fm.dao.impl;

import com.fm.dao.IUserRoleDao;
import com.fm.domain.UserEntity;
import com.fm.domain.UserRole;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserEntity: pawel
 * Date: 17.12.12
 * Time: 19:40
 */
@Repository
public class UserRoleDaoImpl extends AbstractDaoImpl<UserRole> implements IUserRoleDao
{
   public List<UserRole> getRolesByUser(UserEntity userEntity)
   {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.eq(UserRole.FIELD_USER_ENTITY, userEntity));
      return criteria.list();
   }
}
