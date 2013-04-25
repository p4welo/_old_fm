package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.IMatchGameDao;
import com.fm.domain.MatchGame;
import com.fm.domain.MatchGameTeamRelation;
import com.fm.domain.Season;
import com.fm.domain.Team;
import com.fm.service.IMatchGameService;
import com.fm.service.IMatchGameTeamRelationService;
import com.fm.service.ISeasonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
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
   private IMatchGameTeamRelationService matchGameTeamRelationService;

   @Resource
   private ISeasonService seasonService;

   @Override
   protected IAbstractDao<MatchGame> getDao()
   {
      return (IAbstractDao<MatchGame>) matchGameDao;
   }

   @Override
   @Transactional
   public MatchGame simulateMatch(Team hostTeam, Team guestTeam, Season s)
   {
      Random random = new Random();

      Season season = seasonService.getBySid(s.getSid());

      MatchGame matchGame = new MatchGame();
      matchGame.setGuestScores(random.nextInt(3));
      matchGame.setHostScores(random.nextInt(4));
      matchGame.setMatchDate(new Date());
      matchGame.setSeason(season);
      matchGame = save(matchGame);

      MatchGameTeamRelation hostMatchTeamRelation = new MatchGameTeamRelation();
      hostMatchTeamRelation.setHostTeam(true);
      hostMatchTeamRelation.setTeam(hostTeam);
      hostMatchTeamRelation.setMatchGame(matchGame);
      matchGameTeamRelationService.save(hostMatchTeamRelation);

      MatchGameTeamRelation guestMatchTeamRelation = new MatchGameTeamRelation();
      guestMatchTeamRelation.setHostTeam(false);
      guestMatchTeamRelation.setTeam(guestTeam);
      guestMatchTeamRelation.setMatchGame(matchGame);
      matchGameTeamRelationService.save(guestMatchTeamRelation);

      return matchGame;
   }
}
