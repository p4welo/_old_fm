package com.fm.dao.impl;

import com.fm.dao.IManagerDao;
import com.fm.domain.Manager;
import com.fm.domain.ObjectStateEnum;
import com.fm.domain.Team;
import com.fm.domain.filter.AbstractFilter;
import com.fm.domain.filter.FmFilter;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
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

      String name = filter.getName();
      if (StringUtils.isNotBlank(name))
      {
         criteria.add(Restrictions.like(Manager.FIELD_NAME, name, MatchMode.ANYWHERE));
      }

      String surname = filter.getSurname();
      if (StringUtils.isNotBlank(surname))
      {
         criteria.add(Restrictions.like(Manager.FIELD_SURNAME, surname, MatchMode.ANYWHERE));
      }

      return criteria;
   }

   @Override
   public Manager getByTeam(Team team)
   {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.eq(Manager.FIELD_TEAM, team));
      criteria.setMaxResults(1);
      return (Manager) criteria.uniqueResult();
   }
}
