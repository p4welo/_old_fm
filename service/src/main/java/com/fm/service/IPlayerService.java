package com.fm.service;

import com.fm.domain.Player;
import com.fm.domain.Team;

import java.util.List;

/**
 * User: pawel
 * Date: 01.12.12
 * Time: 00:23
 */
public interface IPlayerService extends IAbstractService<Player>
{
   List<Player> findTeamPlayers(Team team);

   Player getRandom(Team team);
}
