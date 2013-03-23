package com.fm.dao;

import com.fm.domain.League;
import com.fm.domain.Team;

import java.util.List;

/**
 * UserEntity: pawel
 * Date: 01.12.12
 * Time: 00:00
 */
public interface ITeamDao
{
   Long getNextId();

   List<Team> findTeamsFromLeague(League league);

   Integer getLeagueTeamsCount(League league);
}
