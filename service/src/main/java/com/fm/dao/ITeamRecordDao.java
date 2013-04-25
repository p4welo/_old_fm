package com.fm.dao;

import com.fm.domain.Season;
import com.fm.domain.TeamRecord;

import java.util.List;

/**
 * User: pawel
 * Date: 14.12.12
 * Time: 00:17
 */
public interface ITeamRecordDao
{
   List<TeamRecord> findTeamRecordsBySeason(Season season, boolean orderByPlace);
}
