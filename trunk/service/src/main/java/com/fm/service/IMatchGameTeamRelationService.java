package com.fm.service;

import com.fm.domain.MatchGame;
import com.fm.domain.MatchGameTeamRelation;

import java.util.List;

/**
 * User: pawel.radomski
 * Date: 14.12.12
 * Time: 16:34
 */
public interface IMatchGameTeamRelationService extends IAbstractService<MatchGameTeamRelation>
{
   List<MatchGameTeamRelation> getByGame(MatchGame game);
}
