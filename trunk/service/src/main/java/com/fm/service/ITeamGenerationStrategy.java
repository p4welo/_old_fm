package com.fm.service;

import com.fm.domain.League;
import com.fm.domain.Team;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 11.04.13
 * Time: 19:37
 * To change this template use File | Settings | File Templates.
 */
public interface ITeamGenerationStrategy
{
   void generateLeagueCpuTeams(League league);

   Team generateTeam();

   Team generateHumanTeam(Team team);

   String generateCpuTeamName();

   Integer generateTeamAccount();
}
