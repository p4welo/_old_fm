package com.fm.dao;

import com.fm.domain.*;
import com.fm.service.util.SidUtils;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 11.05.13
 * Time: 14:40
 * To change this template use File | Settings | File Templates.
 */
public class TestDomainObjectFactory
{
   public static Name getName()
   {
      Name name = new Name();
      name.setValue("name");
      name.setObjectState(ObjectStateEnum.ACTIVE);
      name.setSid(SidUtils.generate());
      return name;
   }

   public static Authority getAuthority(User user)
   {
      Authority authority = new Authority();
      authority.setUser(user);
      authority.setObjectState(ObjectStateEnum.ACTIVE);
      authority.setSid(SidUtils.generate());
      authority.setAuthority("AUTHORITY");
      return authority;
   }

   public static User getUser()
   {
      User user = new User();
      user.setSid(SidUtils.generate());
      user.setObjectState(ObjectStateEnum.ACTIVE);
      user.setEmail("contact@fm.com");
      user.setLogin("login");
      user.setPassword("VeryLongPassword");
      return user;
   }

   public static League getLeague()
   {
      League league = new League();
      league.setSid(SidUtils.generate());
      league.setObjectState(ObjectStateEnum.ACTIVE);
      league.setLevel(1);
      league.setName("Sample name");
      return league;
   }

   public static Surname getSurname()
   {
      Surname surname = new Surname();
      surname.setSid(SidUtils.generate());
      surname.setObjectState(ObjectStateEnum.ACTIVE);
      surname.setValue("Sample surname");
      return surname;
   }

   public static Manager getManager(Team team, User user)
   {
      Manager manager = new Manager();
      manager.setSid(SidUtils.generate());
      manager.setObjectState(ObjectStateEnum.ACTIVE);
      manager.setName("Kazimierz");
      manager.setSurname("Górski");
      manager.setTeam(team);
      manager.setUser(user);
      return manager;
   }

   public static MatchGame getMatchGame(Season season)
   {
      MatchGame game = new MatchGame();
      game.setSid(SidUtils.generate());
      game.setObjectState(ObjectStateEnum.ACTIVE);
      game.setHostScores(1);
      game.setGuestScores(0);
      game.setMatchDate(new Date());
      game.setSeason(season);
      game.setRound(3);
      return game;
   }

   public static Position getPosition()
   {
      Position position = new Position();
      position.setSid(SidUtils.generate());
      position.setObjectState(ObjectStateEnum.ACTIVE);
      position.setFullName("Full Position Name");
      position.setShortName("SN");
      return position;
   }

   public static Season getSeason(League league)
   {
      Season season = new Season();
      season.setSid(SidUtils.generate());
      season.setObjectState(ObjectStateEnum.ACTIVE);
      season.setLeague(league);
      season.setNumber(1);
      return season;
   }

   public static Team getTeam(League league)
   {
      Team team = new Team();
      team.setSid(SidUtils.generate());
      team.setObjectState(ObjectStateEnum.ACTIVE);
      team.setLeague(league);
      team.setName("FC Team");
      team.setType(TeamTypeEnum.HUMAN);
      team.setAccount(100000);
      return team;
   }

   public static TeamRecord getTeamRecord(Team team, Season season)
   {
      TeamRecord teamRecord = new TeamRecord();
      teamRecord.setSid(SidUtils.generate());
      teamRecord.setObjectState(ObjectStateEnum.ACTIVE);
      teamRecord.setTeam(team);
      teamRecord.setSeason(season);
      teamRecord.setTeamName(team.getName());
      teamRecord.setPlace(2);
      teamRecord.setWinsCount(3);
      teamRecord.setDrawsCount(2);
      teamRecord.setLosesCount(1);
      teamRecord.setGoalsScored(11);
      teamRecord.setGoalsAllowed(4);
      teamRecord.setGoalsDifference(7);
      teamRecord.setRoundNumber(3);
      return teamRecord;
   }
}
