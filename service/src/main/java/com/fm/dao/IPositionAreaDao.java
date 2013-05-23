package com.fm.dao;

import com.fm.domain.Position;
import com.fm.domain.PositionArea;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 14.04.13
 * Time: 18:01
 * To change this template use File | Settings | File Templates.
 */
public interface IPositionAreaDao extends IAbstractDao<PositionArea>
{
   List<PositionArea> findByPosition(Position position);
}
