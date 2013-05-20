package com.fm.admin.pages.leagueListPage.cmp;

import com.fm.domain.League;
import com.fm.domain.Progress;
import com.fm.service.ILeagueService;

/**
 * User: pawel.radomski
 * Date: 20.05.13
 * Time: 13:44
 */
public class GenerateLeagueThread extends Thread
{
   private final League league;

   private final Boolean generateTeams;

   private Progress progress;

   private final ILeagueService leagueService;

   public GenerateLeagueThread(League league, Boolean generateTeams, Progress progress, ILeagueService leagueService)
   {
      this.league = league;
      this.generateTeams = generateTeams;
      this.progress = progress;
      this.leagueService = leagueService;
   }

   @Override
   public void run()
   {
      leagueService.save(league, generateTeams, progress);
   }
}
