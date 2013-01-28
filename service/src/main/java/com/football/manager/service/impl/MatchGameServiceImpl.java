package com.football.manager.service.impl;

import com.football.manager.dao.IAbstractDao;
import com.football.manager.dao.IMatchGameDao;
import com.football.manager.domain.MatchGame;
import com.football.manager.service.IMatchGameService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UserEntity: pawel
 * Date: 14.12.12
 * Time: 01:24
 */
@Service
public class MatchGameServiceImpl extends AbstractServiceImpl<MatchGame> implements IMatchGameService
{
   @Resource
   private IMatchGameDao matchGameDao;

   @Override
   protected IAbstractDao<MatchGame> getDao()
   {
      return (IAbstractDao<MatchGame>) matchGameDao;
   }
}
