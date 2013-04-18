package com.fm.service;

import com.fm.domain.Season;
import com.fm.domain.TeamRecord;

import java.util.List;

/**
 * User: pawel
 * Date: 14.12.12
 * Time: 00:18
 */
public interface ITeamRecordService extends IAbstractService<TeamRecord>
{
   List<TeamRecord> findTeamRecordsBySeason(Season selectedSeason);
}
