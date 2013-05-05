package com.fm.service.impl;

import com.fm.service.IPlayerGenerationStrategy;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 05.05.13
 * Time: 15:39
 * To change this template use File | Settings | File Templates.
 */
public class PlayerGenerationStrategy implements IPlayerGenerationStrategy
{
   @Override
   public int getPotential(int age)
   {
      int value;
      double m = (3500 - 100 * age) / 17.0;
      int s = 13;

      Random r = new Random();
      do
      {
         double val = r.nextGaussian() * s + m;
         value = (int) Math.round(val);
      }
      while (value < 0 || value > 100);
      return value;
   }
}
