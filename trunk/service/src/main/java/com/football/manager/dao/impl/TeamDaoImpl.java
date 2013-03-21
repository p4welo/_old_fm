package com.football.manager.dao.impl;

import com.football.manager.dao.ITeamDao;
import com.football.manager.domain.DataEntity;
import com.football.manager.domain.League;
import com.football.manager.domain.Team;
import org.hibernate.Criteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserEntity: pawel
 * Date: 01.12.12
 * Time: 00:00
 */

@Repository
public class TeamDaoImpl extends AbstractDaoImpl<Team> implements ITeamDao
{
   public Long getNextId()
   {
      Criteria criteria = createCriteria();
      criteria.addOrder(Property.forName(DataEntity.FIELD_ID).desc());
      criteria.setMaxResults(1);

      List<Team> teams = criteria.list();

      if (teams.size() > 0)
      {
         Team team = teams.get(0);
         return (team.getId() + 1);
      }
      else
      {
         return null;
      }
   }

   @Override
   public List<Team> findTeamsFromLeague(League league)
   {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.eq(Team.FIELD_LEAGUE, league));
      return criteria.list();
   }

   @Override
   public Integer getLeagueTeamsCount(League league)
   {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.eq(Team.FIELD_LEAGUE, league));
      List<Team> result = criteria.list();
      if (result != null && result.size() > 0)
      {
         return result.size();
      }
      else
      {
         return 0;
      }
   }
}