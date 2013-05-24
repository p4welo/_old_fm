package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.IMatchGameDao;
import com.fm.domain.*;
import com.fm.service.IMatchGameService;
import com.fm.service.IPlayerService;
import com.fm.service.IPlayerStatsService;
import com.fm.service.ISeasonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * User: pawel
 * Date: 14.12.12
 * Time: 01:24
 */
@Service
public class MatchGameServiceImpl extends AbstractServiceImpl<MatchGame> implements IMatchGameService
{
   @Resource
   private IMatchGameDao matchGameDao;

   @Resource
   private ISeasonService seasonService;

   @Resource
   private IPlayerStatsService playerStatsService;

   @Resource
   private IPlayerService playerService;

   @Override
   protected IAbstractDao<MatchGame> getDao()
   {
      return (IAbstractDao<MatchGame>) matchGameDao;
   }

   @Override
   @Transactional
   public MatchGame simulateMatch(Team hostTeam, Team guestTeam, Season s, int round)
   {
      Random random = new Random();

      Season season = seasonService.getBySid(s.getSid());

      MatchGame matchGame = new MatchGame();
      int guestScores = random.nextInt(3);
      matchGame.setGuestScores(guestScores);
      matchGame.setGuestSid(guestTeam.getSid());
      matchGame.setGuestName(guestTeam.getName());
      int hostScores = random.nextInt(4);
      matchGame.setHostScores(hostScores);
      matchGame.setHostSid(hostTeam.getSid());
      matchGame.setHostName(hostTeam.getName());
      matchGame.setMatchDate(new Date());
      matchGame.setSeason(season);
      matchGame.setRound(round);
      matchGame = save(matchGame);

      for (int i = 0; i < hostScores; i++)
      {
         Player player = playerService.getRandom(hostTeam);
         PlayerStats stats = new PlayerStats();
         stats.setDate(new Date());
         stats.setPlayerSid(player.getSid());
         stats.setPlayerName(player.getName());
         stats.setPlayerSurname(player.getSurname());
         stats.setSeasonSid(season.getSid());
         stats.setMatchSid(matchGame.getSid());
         stats.setType(PlayerStatsTypeEnum.GOAL);
         stats.setMatchMinute(random.nextInt(90));
         stats.setTeamSid(hostTeam.getSid());
         playerStatsService.save(stats);
      }

      int randomYellow = random.nextInt(2);
      for (int i = 0; i < randomYellow; i++)
      {
         Player player = playerService.getRandom(hostTeam);
         PlayerStats stats = new PlayerStats();
         stats.setDate(new Date());
         stats.setPlayerSid(player.getSid());
         stats.setPlayerName(player.getName());
         stats.setPlayerSurname(player.getSurname());
         stats.setSeasonSid(season.getSid());
         stats.setMatchSid(matchGame.getSid());
         stats.setType(PlayerStatsTypeEnum.YELLOW_CARD);
         stats.setMatchMinute(random.nextInt(90));
         stats.setTeamSid(hostTeam.getSid());
         playerStatsService.save(stats);
      }

      for (int i = 0; i < guestScores; i++)
      {
         Player player = playerService.getRandom(guestTeam);
         PlayerStats stats = new PlayerStats();
         stats.setDate(new Date());
         stats.setPlayerSid(player.getSid());
         stats.setPlayerName(player.getName());
         stats.setPlayerSurname(player.getSurname());
         stats.setSeasonSid(season.getSid());
         stats.setMatchSid(matchGame.getSid());
         stats.setType(PlayerStatsTypeEnum.GOAL);
         stats.setMatchMinute(random.nextInt(90));
         stats.setTeamSid(guestTeam.getSid());
         playerStatsService.save(stats);
      }

      randomYellow = random.nextInt(2);
      for (int i = 0; i < randomYellow; i++)
      {
         Player player = playerService.getRandom(guestTeam);
         PlayerStats stats = new PlayerStats();
         stats.setDate(new Date());
         stats.setPlayerSid(player.getSid());
         stats.setPlayerName(player.getName());
         stats.setPlayerSurname(player.getSurname());
         stats.setSeasonSid(season.getSid());
         stats.setMatchSid(matchGame.getSid());
         stats.setType(PlayerStatsTypeEnum.YELLOW_CARD);
         stats.setMatchMinute(random.nextInt(90));
         stats.setTeamSid(guestTeam.getSid());
         playerStatsService.save(stats);
      }

      //TODO: zrobić ocenę zawodników, ale pierw musi być ustalanie składu na mecz

      return matchGame;
   }

   @Override
   @Transactional
   public List<MatchGame> getByRoundInSeason(Season season, Integer round)
   {
      return matchGameDao.getByRoundInSeason(season, round);
   }
}
