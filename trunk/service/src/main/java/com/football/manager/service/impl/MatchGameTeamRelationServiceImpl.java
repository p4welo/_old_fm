package com.football.manager.service.impl;

import com.football.manager.dao.IAbstractDao;
import com.football.manager.dao.IMatchGameTeamRelationDao;
import com.football.manager.domain.MatchGameTeamRelation;
import com.football.manager.service.IMatchGameTeamRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UserEntity: pawel.radomski
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
}
