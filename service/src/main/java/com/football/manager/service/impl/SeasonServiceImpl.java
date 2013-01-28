package com.football.manager.service.impl;

import com.football.manager.dao.IAbstractDao;
import com.football.manager.dao.ISeasonDao;
import com.football.manager.domain.Season;
import com.football.manager.service.ISeasonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UserEntity: pawel
 * Date: 14.12.12
 * Time: 00:03
 */
@Service(SeasonServiceImpl.BEAN_NAME)
public class SeasonServiceImpl extends AbstractServiceImpl<Season> implements ISeasonService
{
   public static final String BEAN_NAME = "seasonService";

   @Resource
   private ISeasonDao seasonDao;

   @Override
   protected IAbstractDao<Season> getDao()
   {
      return (IAbstractDao<Season>) seasonDao;
   }
}
