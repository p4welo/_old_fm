package com.fm.service;

import com.fm.domain.League;

/**
 * UserEntity: pawel
 * Date: 13.12.12
 * Time: 23:09
 */
public interface ILeagueService extends IAbstractService<League>
{
   League save(League league, boolean generateTeams);
}
