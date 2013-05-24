package com.fm.dao;

import com.fm.domain.Manager;
import com.fm.domain.Team;

/**
 * User: pawel
 * Date: 01.12.12
 * Time: 00:02
 */
public interface IManagerDao extends IAbstractDao<Manager>
{
   Manager getByTeam(Team team);
}
