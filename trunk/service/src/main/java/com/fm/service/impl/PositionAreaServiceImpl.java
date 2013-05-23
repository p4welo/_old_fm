package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.IPositionAreaDao;
import com.fm.domain.Position;
import com.fm.domain.PositionArea;
import com.fm.service.IPositionAreaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 14.04.13
 * Time: 18:03
 * To change this template use File | Settings | File Templates.
 */
@Service(PositionAreaServiceImpl.BEAN_NAME)
public class PositionAreaServiceImpl extends AbstractServiceImpl<PositionArea> implements IPositionAreaService
{
   public static final String BEAN_NAME = "positionAreaService";

   @Resource
   private IPositionAreaDao positionAreaDao;

   @Override
   protected IAbstractDao<PositionArea> getDao()
   {
      return positionAreaDao;
   }

   @Override
   @Transactional
   public Map<Position, List<Integer>> findAllByPositions(List<Position> positions)
   {
      Map<Position, List<Integer>> areas = new HashMap<Position, List<Integer>>();
      if (!CollectionUtils.isEmpty(positions))
      {
         for (Position position : positions)
         {
            List<PositionArea> list = positionAreaDao.findByPosition(position);
            List<Integer> integers = new ArrayList<Integer>();
            if (!CollectionUtils.isEmpty(list))
            {
               for (PositionArea area : list)
               {
                  integers.add(area.getArea());
               }
            }
            areas.put(position, integers);
         }
      }
      return areas;
   }

   @Override
   @Transactional
   public List<Integer> findByPosition(Position position)
   {
      List<PositionArea> list = positionAreaDao.findByPosition(position);
      List<Integer> integers = new ArrayList<Integer>();
      if (!CollectionUtils.isEmpty(list))
      {
         for (PositionArea area : list)
         {
            integers.add(area.getArea());
         }
      }
      return integers;
   }

   @Override
   @Transactional
   public PositionArea addPositionArea(Position position, int area)
   {
      PositionArea positionArea = new PositionArea();
      positionArea.setArea(area);
      positionArea.setPosition(position);
      return save(positionArea);
   }

   @Override
   @Transactional
   public void removePositionArea(Position position, int area)
   {
      List<PositionArea> positionAreas = positionAreaDao.findByPosition(position);
      if (!CollectionUtils.isEmpty(positionAreas))
      {
         for (PositionArea positionArea : positionAreas)
         {
            if (StringUtils.equals(positionArea.getPosition().getSid(), position.getSid())
                    && positionArea.getArea() == area)
            {
               delete(positionArea);
            }
         }
      }
   }

   @Override
   @Transactional
   public int countAreasByPosition(Position position)
   {
      List<PositionArea> areas = positionAreaDao.findByPosition(position);
      if (!CollectionUtils.isEmpty(areas))
      {
         return areas.size();
      }
      return 0;
   }
}
