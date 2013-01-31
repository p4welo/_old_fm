package com.football.manager.service.impl;

import com.football.manager.dao.IAbstractDao;
import com.football.manager.dao.ITeamRecordDao;
import com.football.manager.domain.Season;
import com.football.manager.domain.TeamRecord;
import com.football.manager.service.ITeamRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserEntity: pawel
 * Date: 14.12.12
 * Time: 00:18
 */
@Service(TeamRecordServiceImpl.BEAN_NAME)
public class TeamRecordServiceImpl extends AbstractServiceImpl<TeamRecord> implements ITeamRecordService
{
   public static final String BEAN_NAME = "teamRecordService";

   @Resource
   private ITeamRecordDao teamRecordDao;

   @Override
   protected IAbstractDao<TeamRecord> getDao()
   {
      return (IAbstractDao<TeamRecord>) teamRecordDao;
   }

   @Override
   @Transactional
   public List<TeamRecord> findTeamRecordsBySeason(Season season)
   {
      return teamRecordDao.findTeamRecordsBySeason(season);
   }
}
