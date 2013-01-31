package com.football.manager.dao;

import com.football.manager.domain.League;
import com.football.manager.domain.Season;

/**
 * UserEntity: pawel
 * Date: 14.12.12
 * Time: 00:01
 */
public interface ISeasonDao
{
   Season getActiveSeason(League league);

   Season getSeasonByNumber(League league, int number);

   int getNextSeasonNumber(League league);
}
