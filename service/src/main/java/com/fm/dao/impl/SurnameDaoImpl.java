package com.fm.dao.impl;

import com.fm.dao.ISurnameDao;
import com.fm.domain.Surname;
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
 * Time: 00:06
 */
@Repository
public class SurnameDaoImpl extends AbstractDaoImpl<Surname> implements ISurnameDao
{
   @Override
   public Criteria createCriteriaFromSearchParams(AbstractFilter abstractFilter)
   {
      FmFilter filter = (FmFilter) abstractFilter;
      Criteria criteria = createCriteria();

      String surname = filter.getSurname();
      if (StringUtils.isNotEmpty(surname))
      {
         criteria.add(Restrictions.like(Surname.FIELD_VALUE, surname, MatchMode.START));
      }

      return criteria;
   }
}
