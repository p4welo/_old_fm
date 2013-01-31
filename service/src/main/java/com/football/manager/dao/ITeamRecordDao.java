package com.football.manager.dao;

import com.football.manager.domain.Season;
import com.football.manager.domain.TeamRecord;

import java.util.List;

/**
 * UserEntity: pawel
 * Date: 14.12.12
 * Time: 00:17
 */
public interface ITeamRecordDao
{
   List<TeamRecord> findTeamRecordsBySeason(Season season);
}
