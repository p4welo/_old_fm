package com.football.manager.service;

import com.football.manager.domain.Team;

/**
 * UserEntity: pawel
 * Date: 01.12.12
 * Time: 00:24
 */
public interface ITeamService extends IAbstractService<Team>
{
   Team generate();
}
