package com.fm.service.impl;

import com.fm.domain.League;
import com.fm.domain.Team;
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
   @Resource
   private ITeamService teamService;

   public static final String BEAN_NAME = "teamGenerationStrategy";

   public static final Integer TEAMS_IN_LEAGUE = 15;

   @Override
   public void generate(League league)
   {
      for (int i = 0; i < TEAMS_IN_LEAGUE; i++)
      {
         Team team = generateTeam();
         team.setLeague(league);
         teamService.save(team);
      }
   }

   @Override
   @Transactional
   public Team generateTeam()
   {
      Random generator = new Random();

      Team team = new Team();

      team.setAccount(generator.nextInt(80) + 10);
      Long nextId = teamService.getNextId();
      if (nextId != null)
      {
         team.setName("PC_" + String.valueOf(nextId));
      }
      else
      {
         team.setName("PC_First");
      }

      return team;
   }
}
