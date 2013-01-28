package com.football.manager.dao.impl;

import com.football.manager.dao.IUserEntityDao;
import com.football.manager.domain.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * UserEntity: pawel
 * Date: 17.12.12
 * Time: 19:31
 */
@Repository
public class UserEntityDaoImpl extends AbstractDaoImpl<UserEntity> implements IUserEntityDao
{
   public UserEntity findByLogin(String login)
   {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.eq(UserEntity.FIELD_LOGIN, login));
      criteria.setMaxResults(1);
      return (UserEntity) criteria.uniqueResult();
   }
}
