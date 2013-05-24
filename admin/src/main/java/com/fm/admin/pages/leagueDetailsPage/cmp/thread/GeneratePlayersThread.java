package com.fm.admin.pages.leagueDetailsPage.cmp.thread;

import com.fm.domain.Progress;
import com.fm.domain.TeamRecord;
import com.fm.service.ITeamRecordService;

import java.util.List;

/**
 * User: pawel.radomski
 * Date: 24.05.13
 * Time: 13:55
 */
public class GeneratePlayersThread implements Runnable
{
   private List<TeamRecord> teamRecords;

   private final ITeamRecordService teamRecordService;

   private Progress generateProgress;

   public GeneratePlayersThread(List<TeamRecord> teamRecords, ITeamRecordService teamRecordService,
                                Progress generateProgress)
   {
      this.teamRecords = teamRecords;
      this.teamRecordService = teamRecordService;
      this.generateProgress = generateProgress;
   }

   @Override
   public void run()
   {
      generateProgress.setValue(50);
      teamRecordService.generatePlayers(teamRecords);
      generateProgress.setValue(0);
   }
}
