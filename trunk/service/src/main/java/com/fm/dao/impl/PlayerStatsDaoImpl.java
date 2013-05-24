package com.fm.dao.impl;

import com.fm.dao.IPlayerStatsDao;
import com.fm.domain.PlayerStats;
import com.fm.domain.PlayerStatsTypeEnum;
import com.fm.domain.filter.AbstractFilter;
import com.fm.domain.filter.StatsFilter;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * User: pawel
 * Date: 13.12.12
 * Time: 23:16
 */
@Repository
public class PlayerStatsDaoImpl extends AbstractDaoImpl<PlayerStats> implements IPlayerStatsDao
{
   @Override
   public Criteria createCriteriaFromSearchParams(AbstractFilter abstractFilter)
   {
      StatsFilter filter = (StatsFilter) abstractFilter;
      Criteria criteria = createCriteria();

      String matchSid = filter.getMatchSid();
      if (StringUtils.isNotEmpty(matchSid))
      {
         criteria.add(Restrictions.eq(PlayerStats.FIELD_MATCH_SID, matchSid));
      }

      String seasonSid = filter.getSeasonSid();
      if (StringUtils.isNotEmpty(seasonSid))
      {
         criteria.add(Restrictions.eq(PlayerStats.FIELD_SEASON_SID, seasonSid));
      }

      String teamSid = filter.getTeamSid();
      if (StringUtils.isNotEmpty(teamSid))
      {
         criteria.add(Restrictions.eq(PlayerStats.FIELD_TEAM_SID, teamSid));
      }

      String playerSid = filter.getPlayerSid();
      if (StringUtils.isNotEmpty(playerSid))
      {
         criteria.add(Restrictions.eq(PlayerStats.FIELD_PLAYER_SID, playerSid));
      }

      PlayerStatsTypeEnum type = filter.getType();
      if (type != null)
      {
         criteria.add(Restrictions.eq(PlayerStats.FIELD_TYPE, type));
      }

      return criteria;

   }
}
