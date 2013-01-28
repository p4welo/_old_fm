package com.football.manager.dao;

import com.football.manager.domain.League;
import com.football.manager.domain.Team;

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
}
