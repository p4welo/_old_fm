package com.fm.service.impl;

import com.fm.domain.*;
import com.fm.domain.defined.SystemParameters;
import com.fm.service.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
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

   public static final int INIT_GK_COUNT = 2;

   public static final int INIT_LB_COUNT = 3;

   public static final int INIT_OB_COUNT = 6;

   public static final int INIT_MIDDLE_P_COUNT = 4;

   public static final int INIT_WING_P_COUNT = 4;

   public static final int INIT_N_COUNT = 3;

   @Resource
   private ITeamService teamService;

   @Resource
   private ILeagueService leagueService;

   @Resource
   private IPlayerService playerService;

   @Resource
   private ISystemParameterService systemParameterService;

   @Resource
   private IPlayerGenerationStrategy playerGenerationStrategy;

   private Logger logger = Logger.getLogger(TeamGenerationStrategyImpl.class);

   @Override
   public void generateLeagueCpuTeams(League league, Progress progress)
   {
      Integer teamCount = 16;
      String value = systemParameterService.getByKey(SystemParameters.TEAM_COUNT_PER_LEAGUE);
      if (value != null)
      {
         teamCount = Integer.valueOf(value);
      }
      for (int i = 0; i < teamCount; i++)
      {
         progress.setValue(i * 100 / teamCount);
         Team team = generateTeam();
         team.setLeague(league);
         team.setType(TeamTypeEnum.CPU);
         team = teamService.save(team);
         generatePlayers(team);
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
   public List<Player> generatePlayers(Team team)
   {
      List<Player> players = new ArrayList<Player>();
      for (int i = 0; i < INIT_GK_COUNT; i++)
      {
         Player player = playerGenerationStrategy.getGoalkeeper(team);
         player = playerService.save(player);
         players.add(player);
      }
      for (int i = 0; i < INIT_LB_COUNT; i++)
      {
         Player player = playerGenerationStrategy.getLibero(team);
         player = playerService.save(player);
         players.add(player);
      }
      for (int i = 0; i < INIT_OB_COUNT; i++)
      {
         Player player = playerGenerationStrategy.getDefender(team);
         player = playerService.save(player);
         players.add(player);
      }
      for (int i = 0; i < INIT_MIDDLE_P_COUNT; i++)
      {
         Player player = playerGenerationStrategy.getMiddleMidfielder(team);
         player = playerService.save(player);
         players.add(player);
      }
      for (int i = 0; i < INIT_WING_P_COUNT; i++)
      {
         Player player = playerGenerationStrategy.getWingMidfielder(team);
         player = playerService.save(player);
         players.add(player);
      }
      for (int i = 0; i < INIT_N_COUNT; i++)
      {
         Player player = playerGenerationStrategy.getStriker(team);
         player = playerService.save(player);
         players.add(player);
      }
      return players;
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
