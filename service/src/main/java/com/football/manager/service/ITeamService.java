package com.football.manager.service;

import com.football.manager.domain.League;
import com.football.manager.domain.Team;

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
}
