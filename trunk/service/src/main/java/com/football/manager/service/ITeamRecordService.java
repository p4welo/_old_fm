package com.football.manager.service;

import com.football.manager.domain.Season;
import com.football.manager.domain.TeamRecord;

import java.util.List;

/**
 * UserEntity: pawel
 * Date: 14.12.12
 * Time: 00:18
 */
public interface ITeamRecordService extends IAbstractService<TeamRecord>
{
   List<TeamRecord> findTeamRecordsBySeason(Season selectedSeason);
}
