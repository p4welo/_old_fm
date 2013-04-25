package com.fm.domain.comparator;

import com.fm.domain.TeamRecord;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 25.04.13
 * Time: 20:28
 * To change this template use File | Settings | File Templates.
 */
public class TeamRecordComparator implements Comparator<TeamRecord>
{
   @Override
   public int compare(TeamRecord record1, TeamRecord record2)
   {
      if (record1.getPointsCount() > record2.getPointsCount())
      {
         return -1;
      }
      else if (record1.getPointsCount() < record2.getPointsCount())
      {
         return 1;
      }
      else
      {
         if (record1.getGoalsDifference() > record2.getGoalsDifference())
         {
            return -1;
         }
         else if (record1.getGoalsDifference() < record2.getGoalsDifference())
         {
            return 1;
         }
         else
         {
            if (record1.getGoalsScored() > record2.getGoalsScored())
            {
               return -1;
            }
            else
            {
               return 1;
            }
         }
      }
   }
}
