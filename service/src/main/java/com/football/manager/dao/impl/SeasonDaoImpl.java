package com.football.manager.dao.impl;

import com.football.manager.dao.ISeasonDao;
import com.football.manager.domain.League;
import com.football.manager.domain.Season;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * UserEntity: pawel
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
//      TODO zmienić na uwzględnianie po statusie a nie numerze
      criteria.addOrder(Order.desc(Season.FIELD_NUMBER));
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
}
