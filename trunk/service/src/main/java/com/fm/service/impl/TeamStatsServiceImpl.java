package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.ITeamStatsDao;
import com.fm.domain.*;
import com.fm.service.IManagerService;
import com.fm.service.ITeamStatsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * User: pawel.radomski
 * Date: 24.05.13
 * Time: 16:43
 */
@Service(TeamStatsServiceImpl.BEAN_NAME)
public class TeamStatsServiceImpl extends AbstractServiceImpl<TeamStats> implements ITeamStatsService
{
   public static final String BEAN_NAME = "teamStatsService";

   @Resource
   private ITeamStatsDao teamStatsDao;

   @Resource
   private IManagerService managerService;

   @Override
   protected IAbstractDao<TeamStats> getDao()
   {
      return teamStatsDao;
   }

   @Override
   @Transactional(readOnly = false)
   public void createTeamStats(Team hostTeam, int hostScores, Team guestTeam, int guestScores, Season season,
                               MatchGame matchGame)
   {
      TeamStats hostStats = new TeamStats();
      hostStats.setMatchSid(matchGame.getSid());
      hostStats.setSeasonSid(season.getSid());
      hostStats.setTeamSid(hostTeam.getSid());
      hostStats.setCreationDate(new Date());

      TeamStats guestStats = new TeamStats();
      guestStats.setMatchSid(matchGame.getSid());
      guestStats.setSeasonSid(season.getSid());
      guestStats.setTeamSid(guestTeam.getSid());
      guestStats.setCreationDate(new Date());

      if (hostScores > guestScores)
      {
         hostStats.setType(TeamStatsTypeEnum.WIN);
         guestStats.setType(TeamStatsTypeEnum.LOSS);
      }
      else if (hostScores < guestScores)
      {
         hostStats.setType(TeamStatsTypeEnum.LOSS);
         guestStats.setType(TeamStatsTypeEnum.WIN);
      }
      else
      {
         hostStats.setType(TeamStatsTypeEnum.DRAW);
         guestStats.setType(TeamStatsTypeEnum.DRAW);
      }

      Manager hostManager = managerService.getByTeam(hostTeam);
      Manager guestManager = managerService.getByTeam(guestTeam);

      if (hostManager != null)
      {
         hostStats.setManagerSid(hostManager.getSid());
      }
      if (guestManager != null)
      {
         guestStats.setManagerSid(guestManager.getSid());
      }

      save(hostStats);
      save(guestStats);
   }
}
