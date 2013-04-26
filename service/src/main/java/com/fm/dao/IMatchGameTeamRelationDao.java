package com.fm.dao;

import com.fm.domain.MatchGame;
import com.fm.domain.MatchGameTeamRelation;

import java.util.List;

/**
 * User: pawel.radomski
 * Date: 14.12.12
 * Time: 16:33
 */
public interface IMatchGameTeamRelationDao
{
   List<MatchGameTeamRelation> getByGame(MatchGame game);
}
