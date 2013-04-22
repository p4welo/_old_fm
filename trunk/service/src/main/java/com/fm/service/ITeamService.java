package com.fm.service;

import com.fm.domain.League;
import com.fm.domain.Team;

import java.util.List;

/**
 * User: pawel
 * Date: 01.12.12
 * Time: 00:24
 */
public interface ITeamService extends IAbstractService<Team>
{
   List<Team> findTeamsFromLeague(League league);

   Integer getLeagueTeamsCount(League league);

   Long getNextId();

   Team findRandomCpuTeam();
}
