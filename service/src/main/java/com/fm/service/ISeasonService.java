package com.fm.service;

import com.fm.domain.League;
import com.fm.domain.Season;

import java.util.List;

/**
 * User: pawel
 * Date: 14.12.12
 * Time: 00:03
 */
public interface ISeasonService extends IAbstractService<Season>
{
   Season getActiveSeason(League league);

   Season getSeasonByNumber(League league, int number);

   List<Season> getLeagueSeasons(League league);

   Season nextSeason(League league);
}
