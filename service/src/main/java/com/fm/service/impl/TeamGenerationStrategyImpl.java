package com.fm.service.impl;

import com.fm.domain.League;
import com.fm.domain.Team;
import com.fm.domain.TeamTypeEnum;
import com.fm.domain.defined.SystemParameters;
import com.fm.service.ILeagueService;
import com.fm.service.ISystemParameterService;
import com.fm.service.ITeamGenerationStrategy;
import com.fm.service.ITeamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 11.04.13
 * Time: 19:37
 * To change this template use File | Settings | File Templates.
 */
@Service(TeamGenerationStrategyImpl.BEAN_NAME)
public class TeamGenerationStrategyImpl implements ITeamGenerationStrategy
{
   public static final String BEAN_NAME = "teamGenerationStrategy";

   @Resource
   private ITeamService teamService;

   @Resource
   private ILeagueService leagueService;

   @Resource
   private ISystemParameterService systemParameterService;

   @Override
   public void generateLeagueCpuTeams(League league)
   {
      Integer teamCount = 15;
      String value = systemParameterService.getByKey(SystemParameters.TEAM_COUNT_PER_LEAGUE);
      if (value != null)
      {
         teamCount = Integer.valueOf(value);
      }
      for (int i = 0; i < teamCount; i++)
      {
         Team team = generateTeam();
         team.setLeague(league);
         team.setType(TeamTypeEnum.CPU);
         teamService.save(team);
      }
   }

   @Override
   @Transactional
   public Team generateTeam()
   {
      Team team = new Team();

      team.setAccount(generateTeamAccount());
      team.setName(generateCpuTeamName());

      return team;
   }

   @Override
   public String generateCpuTeamName()
   {
      Long nextId = teamService.getNextId();
      if (nextId != null)
      {
         return "PC_" + String.valueOf(nextId);
      }
      else
      {
         return "PC_First";
      }
   }

   @Override
   @Transactional
   public Integer generateTeamAccount()
   {
      Random generator = new Random();
      Integer account = generator.nextInt(40000) + 10000;
      return account;
   }

   @Override
   @Transactional
   public Team generateHumanTeam(Team team)
   {
      Integer initialAccount = 50000;
      String value = systemParameterService.getByKey(SystemParameters.INIT_BUDGET_AMOUNT);
      if (value != null)
      {
         initialAccount = Integer.valueOf(value);
      }
      team.setAccount(initialAccount);
      team.setType(TeamTypeEnum.HUMAN);

      return team;
   }
}
