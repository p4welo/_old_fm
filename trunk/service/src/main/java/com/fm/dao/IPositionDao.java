package com.fm.dao;

import com.fm.domain.Position;

/**
 * User: pawel
 * Date: 01.12.12
 * Time: 00:02
 */
public interface IPositionDao
{
   Position getByShortName(String shortName);
}
