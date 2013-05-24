package com.fm.service;

import com.fm.domain.Manager;
import com.fm.domain.Team;

/**
 * User: pawel
 * Date: 01.12.12
 * Time: 00:23
 */
public interface IManagerService extends IAbstractService<Manager>
{
   Manager createNewManager(Manager manager);

   Manager getByTeam(Team team);
}
