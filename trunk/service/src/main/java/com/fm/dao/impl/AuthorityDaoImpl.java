package com.fm.dao.impl;

import com.fm.dao.IAuthorityDao;
import com.fm.domain.Authority;
import com.fm.domain.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: pawel
 * Date: 17.12.12
 * Time: 19:40
 */
@Repository
public class AuthorityDaoImpl extends AbstractDaoImpl<Authority> implements IAuthorityDao
{
   public List<Authority> getAuthoritiesByUser(User user)
   {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.eq(Authority.FIELD_USER_ENTITY, user));
      return criteria.list();
   }
}
