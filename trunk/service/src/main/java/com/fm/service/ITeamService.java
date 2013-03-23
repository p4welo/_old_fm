package com.fm.service;

import com.fm.domain.League;
import com.fm.domain.Team;

import java.util.List;

/**
 * UserEntity: pawel
 * Date: 01.12.12
 * Time: 00:24
 */
public interface ITeamService extends IAbstractService<Team>
{
   Team generate();

   List<Team> findTeamsFromLeague(League league);

   Integer getLeagueTeamsCount(League league);
}
