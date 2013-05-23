package com.fm.dao;

import com.fm.domain.Player;
import com.fm.domain.Team;

import java.util.List;

/**
 * User: pawel
 * Date: 30.11.12
 * Time: 23:58
 */
public interface IPlayerDao extends IAbstractDao<Player>
{
   List<Player> findTeamPlayers(Team team);

   Player getRandom(Team team);
}
