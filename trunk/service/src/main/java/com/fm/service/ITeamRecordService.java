package com.fm.service;

import com.fm.domain.MatchGame;
import com.fm.domain.Season;
import com.fm.domain.Team;
import com.fm.domain.TeamRecord;

import java.util.List;

/**
 * User: pawel
 * Date: 14.12.12
 * Time: 00:18
 */
public interface ITeamRecordService extends IAbstractService<TeamRecord>
{
   List<TeamRecord> simulateNextRound(Season season);

   List<TeamRecord> findTeamRecordsBySeason(Season season, boolean orderByPlace);

   TeamRecord recalculateTeamRecord(TeamRecord oldRecord, MatchGame matchGame, Boolean isHost);

   void recalculatePlaces(List<TeamRecord> newRecords);

   List<TeamRecord> findAllTeamRecordsFromSeason(Team team, Season season);

   List<Integer> getPlayedRoundListBySeason(Season season);
}
