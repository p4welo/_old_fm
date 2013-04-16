package com.fm.dao.impl;

import com.fm.dao.INameDao;
import com.fm.domain.Name;
import com.fm.domain.filter.AbstractFilter;
import com.fm.domain.filter.FmFilter;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * UserEntity: pawel
 * Date: 01.12.12
 * Time: 00:05
 */
@Repository
public class NameDaoImpl extends AbstractDaoImpl<Name> implements INameDao
{
   @Override
   public Criteria createCriteriaFromSearchParams(AbstractFilter abstractFilter)
   {
      FmFilter filter = (FmFilter) abstractFilter;
      Criteria criteria = createCriteria();

      String name = filter.getName();
      if (StringUtils.isNotEmpty(name))
      {
         criteria.add(Restrictions.like(Name.FIELD_VALUE, name, MatchMode.START));
      }

      return criteria;
   }
}
