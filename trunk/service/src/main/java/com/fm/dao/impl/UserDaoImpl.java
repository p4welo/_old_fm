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

   @Override
   public User findByEmail(String email)
   {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.eq(User.FIELD_EMAIL, email));
      criteria.setMaxResults(1);
      return (User) criteria.uniqueResult();
   }
}
