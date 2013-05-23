package com.fm.dao;

import com.fm.domain.MatchGame;
import com.fm.domain.Season;

import java.util.List;

/**
 * User: pawel
 * Date: 14.12.12
 * Time: 01:22
 */
public interface IMatchGameDao extends IAbstractDao<MatchGame>
{
   List<MatchGame> getByRoundInSeason(Season season, Integer round);
}
