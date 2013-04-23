package com.fm.dao.impl;

import com.fm.dao.IManagerDao;
import com.fm.domain.Manager;
import com.fm.domain.ObjectStateEnum;
import com.fm.domain.filter.AbstractFilter;
import com.fm.domain.filter.FmFilter;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * User: pawel
 * Date: 01.12.12
 * Time: 00:04
 */
@Repository
public class ManagerDaoImpl extends AbstractDaoImpl<Manager> implements IManagerDao
{
   @Override
   public Criteria createCriteriaFromSearchParams(AbstractFilter abstractFilter)
   {
      FmFilter filter = (FmFilter) abstractFilter;
      Criteria criteria = createCriteria();

      ObjectStateEnum objectState = filter.getObjectState();
      if (objectState != null)
      {
         criteria.add(Restrictions.eq(Manager.FIELD_OBJECT_STATE, objectState));
      }

      return criteria;
   }
}
