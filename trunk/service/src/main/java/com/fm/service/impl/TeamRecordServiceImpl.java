package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.ITeamRecordDao;
import com.fm.domain.Season;
import com.fm.domain.TeamRecord;
import com.fm.service.ITeamRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: pawel
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
