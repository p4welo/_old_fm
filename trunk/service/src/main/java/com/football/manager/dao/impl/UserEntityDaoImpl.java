package com.football.manager.dao.impl;

import com.football.manager.dao.IUserEntityDao;
import com.football.manager.domain.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
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
   @Override
   public UserEntity findByLogin(String login)
   {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.eq(UserEntity.FIELD_LOGIN, login));
      criteria.setMaxResults(1);
      return (UserEntity) criteria.uniqueResult();
   }

   @Override
   public UserEntity authenticate(String login, String password)
   {
      Query query = getSessionFactory().getCurrentSession().createSQLQuery(
              "select * from user u where u.login = :login and u.password = md5(:password)")
              .addEntity(UserEntity.class)
              .setParameter(UserEntity.FIELD_LOGIN, login)
              .setParameter(UserEntity.FIELD_PASSWORD, password);
      UserEntity result = (UserEntity) query.uniqueResult();
      return result;
   }
}
