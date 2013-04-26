package com.fm.dao.impl;

import com.fm.dao.IMatchGameTeamRelationDao;
import com.fm.domain.MatchGame;
import com.fm.domain.MatchGameTeamRelation;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: pawel.radomski
 * Date: 14.12.12
 * Time: 16:33
 */
@Repository
public class MatchGameTeamRelationDaoImpl extends AbstractDaoImpl<MatchGameTeamRelation>
        implements IMatchGameTeamRelationDao
{
   @Override
   public List<MatchGameTeamRelation> getByGame(MatchGame game)
   {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.eq(MatchGameTeamRelation.FIELD_MATCH_GAME, game));
      return criteria.list();
   }
}
