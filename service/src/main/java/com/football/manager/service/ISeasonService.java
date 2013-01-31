package com.football.manager.service;

import com.football.manager.domain.League;
import com.football.manager.domain.Season;

/**
 * UserEntity: pawel
 * Date: 14.12.12
 * Time: 00:03
 */
public interface ISeasonService extends IAbstractService<Season>
{
   Season getActiveSeason(League league);

   Season getSeasonByNumber(League league, int number);
}
