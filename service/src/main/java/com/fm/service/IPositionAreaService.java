package com.fm.service;

import com.fm.domain.Position;
import com.fm.domain.PositionArea;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 14.04.13
 * Time: 18:03
 * To change this template use File | Settings | File Templates.
 */
public interface IPositionAreaService extends IAbstractService<PositionArea>
{
   Map<Position, List<Integer>> findAllByPositions(List<Position> positions);
}
