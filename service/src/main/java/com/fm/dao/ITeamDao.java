package com.fm.dao;

import com.fm.domain.League;
import com.fm.domain.Team;

import java.util.List;

/**
 * User: pawel
 * Date: 01.12.12
 * Time: 00:00
 */
public interface ITeamDao extends IAbstractDao<Team>
{
   Long getNextId();

   List<Team> findTeamsFromLeague(League league);

   Integer getLeagueTeamsCount(League league);

   Team findRandomCpuTeam();
}
