package com.fm.dao;

import com.fm.domain.League;
import com.fm.domain.Season;

import java.util.List;

/**
 * User: pawel
 * Date: 14.12.12
 * Time: 00:01
 */
public interface ISeasonDao
{
   Season getActiveSeason(League league);

   Season getSeasonByNumber(League league, int number);

   int getNextSeasonNumber(League league);

   List<Season> getLeagueSeasons(League league);
}
