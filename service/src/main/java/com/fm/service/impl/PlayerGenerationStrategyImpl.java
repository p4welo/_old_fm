package com.fm.service.impl;

import com.fm.domain.*;
import com.fm.service.INameService;
import com.fm.service.IPlayerGenerationStrategy;
import com.fm.service.IPositionService;
import com.fm.service.ISurnameService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 05.05.13
 * Time: 15:39
 * To change this template use File | Settings | File Templates.
 */
@Service(PlayerGenerationStrategyImpl.BEAN_NAME)
public class PlayerGenerationStrategyImpl implements IPlayerGenerationStrategy
{
   public static final String BEAN_NAME = "playerGenerationStrategy";

   @Resource
   private IPositionService positionService;

   @Resource
   private INameService nameService;

   @Resource
   private ISurnameService surnameService;

   @Override
   public int getAge()
   {
      double m = 22.0;
      double s = 3;

      return countGaussianValue(18, 30, s, m);
   }

   @Override
   public int getPotential(int age)
   {
      double m = (3500 - 100 * age) / 17.0;
      double s = 13;

      return countGaussianValue(0, 100, s, m);
   }

   @Override
   public int getHighAbility()
   {
      double m = 15.0;
      double s = 2;

      return countGaussianValue(0, 20, s, m);
   }

   @Override
   public int getStandardAbility()
   {
      double m = 15.0;
      double s = 10 / 3;

      return countGaussianValue(0, 20, s, m);
   }

   @Override
   public int getLowAbility()
   {
      double m = 5;
      double s = 2;

      return countGaussianValue(0, 20, s, m);
   }

   @Override
   public Player getGoalkeeper(Team team)
   {
      Player player = getPlayer(team);

      player.setCrossing(getLowAbility());
      player.setHeading(getLowAbility());
      player.setShots(getLowAbility());
      player.setDribbling(getLowAbility());
      player.setPassing(getLowAbility());
      player.setMarking(getLowAbility());
      player.setTackling(getHighAbility());
      player.setGoalkeeping(getHighAbility());

      Position position = positionService.getByShortName("BR");
      if (position != null)
      {
         player.setPosition(position);
         return player;
      }
      return null;
   }

   @Override
   public Player getLibero(Team team)
   {
      Player player = getPlayer(team);

      player.setCrossing(getLowAbility());
      player.setHeading(getHighAbility());
      player.setShots(getLowAbility());
      player.setDribbling(getLowAbility());
      player.setPassing(getLowAbility());
      player.setMarking(getHighAbility());
      player.setTackling(getHighAbility());
      player.setGoalkeeping(getLowAbility());

      Position position = positionService.getByShortName("LB");
      if (position != null)
      {
         player.setPosition(position);
         return player;
      }
      return null;
   }

   @Override
   public Player getDefender(Team team)
   {
      Player player = getPlayer(team);

      player.setCrossing(getLowAbility());
      player.setHeading(getLowAbility());
      player.setShots(getLowAbility());
      player.setDribbling(getLowAbility());
      player.setPassing(getHighAbility());
      player.setMarking(getHighAbility());
      player.setTackling(getHighAbility());
      player.setGoalkeeping(getLowAbility());

      Position position = getPosition("OL", "OS", "OP");
      if (position != null)
      {
         player.setPosition(position);
         return player;
      }
      return null;
   }

   @Override
   public Player getMiddleMidfielder(Team team)
   {
      Player player = getPlayer(team);

      player.setCrossing(getLowAbility());
      player.setHeading(getLowAbility());
      player.setShots(getLowAbility());
      player.setDribbling(getHighAbility());
      player.setPassing(getHighAbility());
      player.setMarking(getLowAbility());
      player.setTackling(getHighAbility());
      player.setGoalkeeping(getLowAbility());

      Position position = getPosition("DPS", "PS", "OPS");
      if (position != null)
      {
         player.setPosition(position);
         return player;
      }
      return null;
   }

   @Override
   public Player getWingMidfielder(Team team)
   {
      Player player = getPlayer(team);

      player.setCrossing(getHighAbility());
      player.setHeading(getLowAbility());
      player.setShots(getLowAbility());
      player.setDribbling(getHighAbility());
      player.setPassing(getHighAbility());
      player.setMarking(getLowAbility());
      player.setTackling(getLowAbility());
      player.setGoalkeeping(getLowAbility());

      Position position = getPosition("DPL", "DPP", "PL", "PP", "OPL", "OPP");
      if (position != null)
      {
         player.setPosition(position);
         return player;
      }
      return null;
   }

   @Override
   public Player getStriker(Team team)
   {
      Player player = getPlayer(team);

      player.setCrossing(getLowAbility());
      player.setHeading(getHighAbility());
      player.setShots(getHighAbility());
      player.setDribbling(getHighAbility());
      player.setPassing(getLowAbility());
      player.setMarking(getLowAbility());
      player.setTackling(getLowAbility());
      player.setGoalkeeping(getLowAbility());

      Position position = positionService.getByShortName("N");
      if (position != null)
      {
         player.setPosition(position);
         return player;
      }
      return null;
   }

   private Position getPosition(String... shortNames)
   {
      List<Position> positionList = new ArrayList<Position>();
      for (String name : shortNames)
      {
         Position position = positionService.getByShortName(name);
         if (position == null)
         {
            throw new RuntimeException("Position: " + name + " not found!");
         }
         positionList.add(position);
      }
      if (!CollectionUtils.isEmpty(positionList))
      {
         Random r = new Random();
         int i = r.nextInt(positionList.size());
         return positionList.get(i);
      }

      return null;
   }

   @Override
   public Player getPlayer(Team team)
   {
      Player player = new Player();
      player.setTeamSid(team.getSid());

      Name name = nameService.getRandom();
      player.setName(name != null ? name.getValue() : "Jan");
      Surname surname = surnameService.getRandom();
      player.setSurname(surname != null ? surname.getValue() : "Kowalski");

      String avatarPath = getAvatarPath();
      player.setAvatarPath(avatarPath);

      int age = getAge();
      player.setAge(age);
      player.setPotential(getPotential(age));
      player.setEnergy(100);

      player.setSpeed(getStandardAbility());
      player.setStamina(getStandardAbility());

      return player;
   }

   private int countGaussianValue(int MIN_VALUE, int MAX_VALUE, double ST, double M)
   {
      Random r = new Random();
      int value;
      do
      {
         double val = r.nextGaussian() * ST + M;
         value = (int) Math.round(val);
      }
      while (value < MIN_VALUE || value > MAX_VALUE);
      return value;
   }

   public String getAvatarPath()
   {
      Random r = new Random();

      return "/static/img/players/avatar(" + r.nextInt(27) + ").jpg";
   }
}
