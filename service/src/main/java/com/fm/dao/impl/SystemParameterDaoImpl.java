package com.fm.dao.impl;

import com.fm.dao.ISystemParameterDao;
import com.fm.domain.SystemParameter;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 15.04.13
 * Time: 18:07
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class SystemParameterDaoImpl extends AbstractDaoImpl<SystemParameter> implements ISystemParameterDao
{
   @Override
   public String getByKey(String key)
   {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.eq(SystemParameter.FIELD_KEY, key));
      criteria.setMaxResults(1);
      criteria.setProjection(Projections.property(SystemParameter.FIELD_VALUE));
      return (String) criteria.uniqueResult();
   }
}
