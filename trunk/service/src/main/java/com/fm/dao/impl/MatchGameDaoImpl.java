package com.fm.dao.impl;

import com.fm.dao.IMatchGameDao;
import com.fm.domain.MatchGame;
import com.fm.domain.Season;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: pawel
 * Date: 14.12.12
 * Time: 01:23
 */
@Repository
public class MatchGameDaoImpl extends AbstractDaoImpl<MatchGame> implements IMatchGameDao
{
   @Override
   public List<MatchGame> getByRoundInSeason(Season season, Integer round)
   {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.eq(MatchGame.FIELD_SEASON, season));
      criteria.add(Restrictions.eq(MatchGame.FIELD_ROUND, round));
      return criteria.list();
   }
}
