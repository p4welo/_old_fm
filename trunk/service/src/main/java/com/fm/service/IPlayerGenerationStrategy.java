package com.fm.service;

import com.fm.domain.Player;
import com.fm.domain.Team;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 05.05.13
 * Time: 15:38
 * To change this template use File | Settings | File Templates.
 */
public interface IPlayerGenerationStrategy
{
   int getAge();

   int getPotential(int age);

   int getHighAbility();

   int getStandardAbility();

   int getLowAbility();

   Player getGoalkeeper(Team team);

   Player getLibero(Team team);

   Player getDefender(Team team);

   Player getMiddleMidfielder(Team team);

   Player getStriker(Team team);

   Player getPlayer(Team team);

   Player getWingMidfielder(Team team);
}
