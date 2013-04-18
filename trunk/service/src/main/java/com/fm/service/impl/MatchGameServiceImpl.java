package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.IMatchGameDao;
import com.fm.domain.MatchGame;
import com.fm.service.IMatchGameService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * User: pawel
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
