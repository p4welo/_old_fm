package com.fm.service;

import com.fm.domain.MatchGame;
import com.fm.domain.Season;
import com.fm.domain.Team;

import java.util.List;

/**
 * User: pawel
 * Date: 14.12.12
 * Time: 01:24
 */
public interface IMatchGameService extends IAbstractService<MatchGame>
{
   MatchGame simulateMatch(Team hostTeam, Team guestTeam, Season season, int round);

   List<MatchGame> getByRoundInSeason(Season season, Integer round);
}
