package com.fm.service;

import com.fm.domain.MatchGame;
import com.fm.domain.Season;
import com.fm.domain.Team;
import com.fm.domain.TeamStats;

/**
 * User: pawel.radomski
 * Date: 24.05.13
 * Time: 16:43
 */
public interface ITeamStatsService extends IAbstractService<TeamStats>
{
   void createTeamStats(Team hostTeam, int hostScores, Team guestTeam, int guestScores, Season season,
                        MatchGame matchGame);
}
