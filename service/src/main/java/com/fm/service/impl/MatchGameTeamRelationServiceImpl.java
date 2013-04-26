package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.IMatchGameTeamRelationDao;
import com.fm.domain.MatchGame;
import com.fm.domain.MatchGameTeamRelation;
import com.fm.service.IMatchGameTeamRelationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: pawel.radomski
 * Date: 14.12.12
 * Time: 16:35
 */
@Service
public class MatchGameTeamRelationServiceImpl extends AbstractServiceImpl<MatchGameTeamRelation> implements
        IMatchGameTeamRelationService
{
   @Resource
   private IMatchGameTeamRelationDao matchGameTeamRelationDao;

   @Override
   protected IAbstractDao<MatchGameTeamRelation> getDao()
   {
      return (IAbstractDao<MatchGameTeamRelation>) matchGameTeamRelationDao;
   }

   @Override
   @Transactional
   public List<MatchGameTeamRelation> getByGame(MatchGame game)
   {
      return matchGameTeamRelationDao.getByGame(game);
   }
}
