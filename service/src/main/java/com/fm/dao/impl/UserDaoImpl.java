package com.fm.dao.impl;

import com.fm.dao.IUserDao;
import com.fm.domain.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * User: pawel
 * Date: 17.12.12
 * Time: 19:31
 */
@Repository
public class UserDaoImpl extends AbstractDaoImpl<User> implements IUserDao
{
   @Override
   public User findByLogin(String login)
   {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.eq(User.FIELD_LOGIN, login));
      criteria.setMaxResults(1);
      return (User) criteria.uniqueResult();
   }

//   @Override
//   public User authenticate(String login, String password)
//   {
//      Query query = getSessionFactory().getCurrentSession().createSQLQuery(
//              "select * from user u where u.login = :login and u.password = md5(:password)")
//              .addEntity(User.class)
//              .setParameter(User.FIELD_LOGIN, login)
//              .setParameter(User.FIELD_PASSWORD, password);
//      User result = (User) query.uniqueResult();
//      return result;
//   }
}
