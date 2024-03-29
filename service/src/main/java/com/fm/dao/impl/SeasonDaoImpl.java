package com.fm.dao.impl;

import com.fm.dao.ISeasonDao;
import com.fm.domain.League;
import com.fm.domain.ObjectStateEnum;
import com.fm.domain.Season;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: pawel
 * Date: 14.12.12
 * Time: 00:01
 */
@Repository
public class SeasonDaoImpl extends AbstractDaoImpl<Season> implements ISeasonDao
{
   @Override
   public Season getActiveSeason(League league)
   {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.eq(Season.FIELD_LEAGUE, league));
      criteria.add(Restrictions.eq(Season.FIELD_OBJECT_STATE, ObjectStateEnum.ACTIVE));
      criteria.setMaxResults(1);
      return (Season) criteria.uniqueResult();
   }

   @Override
   public Season getSeasonByNumber(League league, int number)
   {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.eq(Season.FIELD_LEAGUE, league));
      criteria.add(Restrictions.eq(Season.FIELD_NUMBER, number));
      criteria.setMaxResults(1);
      return (Season) criteria.uniqueResult();
   }

   @Override
   public int getNextSeasonNumber(League league)
   {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.eq(Season.FIELD_LEAGUE, league));
      criteria.addOrder(Order.desc(Season.FIELD_NUMBER));
      criteria.setMaxResults(1);
      criteria.setProjection(Projections.property(Season.FIELD_NUMBER));
      if (criteria.uniqueResult() == null)
      {
         return 1;
      }
      return (Integer) criteria.uniqueResult() + 1;
   }

   @Override
   public List<Season> getLeagueSeasons(League league)
   {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.eq(Season.FIELD_LEAGUE, league));
      criteria.addOrder(Order.asc(Season.FIELD_NUMBER));
      return criteria.list();
   }
}
