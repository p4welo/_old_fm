package com.fm.admin.pages.leagueListPage.cmp;

import com.fm.domain.League;
import com.fm.domain.Progress;
import com.fm.service.ITeamGenerationStrategy;

/**
 * User: pawel.radomski
 * Date: 20.05.13
 * Time: 13:44
 */
public class GenerateLeagueThread implements Runnable
{
   private final League league;

   private Progress progress;

   private ITeamGenerationStrategy teamGenerationStrategy;

   public GenerateLeagueThread(League league, Progress progress, ITeamGenerationStrategy teamGenerationStrategy)
   {
      this.league = league;
      this.progress = progress;
   }

   @Override
   public void run()
   {
      for (int i = 0; i < 16; i++)
      {
         progress.setValue(i * 100 / 16);
         teamGenerationStrategy.generateLeagueCpuTeam(league);
      }
   }
}
