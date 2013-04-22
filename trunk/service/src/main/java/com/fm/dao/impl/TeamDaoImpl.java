package com.fm.dao.impl;

import com.fm.dao.ITeamDao;
import com.fm.domain.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: pawel
 * Date: 01.12.12
 * Time: 00:00
 */

@Repository
public class TeamDaoImpl extends AbstractDaoImpl<Team> implements ITeamDao
{
   public Long getNextId()
   {
      Criteria criteria = createCriteria(ObjectStateEnum.ACTIVE);
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
      Criteria criteria = createCriteria(ObjectStateEnum.ACTIVE);
      criteria.add(Restrictions.eq(Team.FIELD_LEAGUE, league));
      return criteria.list();
   }

   @Override
   public Integer getLeagueTeamsCount(League league)
   {
      Criteria criteria = createCriteria(ObjectStateEnum.ACTIVE);
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

   @Override
   public Team findRandomCpuTeam()
   {
      Criteria criteria = createCriteria(ObjectStateEnum.ACTIVE);
      criteria.add(Restrictions.eq(Team.FIELD_TYPE, TeamTypeEnum.CPU));
      criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
      criteria.setMaxResults(1);
      return (Team) criteria.uniqueResult();
   }
}
