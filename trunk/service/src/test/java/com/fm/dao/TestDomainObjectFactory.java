package com.fm.dao;

import com.fm.domain.*;
import com.fm.service.util.SidUtils;

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
}
