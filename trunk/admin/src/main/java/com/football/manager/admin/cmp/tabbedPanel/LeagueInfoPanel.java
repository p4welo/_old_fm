package com.football.manager.admin.cmp.tabbedPanel;

import com.football.manager.domain.League;
import com.football.manager.domain.Season;
import com.football.manager.service.ISeasonService;
import com.football.manager.service.ITeamService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * User: pawel.radomski
 * Date: 21.02.13
 * Time: 20:06
 */
public class LeagueInfoPanel extends Panel {
    private League league;

    private Integer teamCount;

    private Season activeSeason;

    @SpringBean
    private ITeamService teamService;

    @SpringBean
    private ISeasonService seasonService;

    public LeagueInfoPanel(String id, League league) {
        super(id);
        this.league = league;

        initModelValues();
        initView();
    }

    private void initView() {
        add(new Label("name", new PropertyModel(this, "league." + League.FIELD_NAME)));
        add(new Label("teamCount", new PropertyModel(this, "teamCount")));
        add(new Label("activeSeason", new PropertyModel(this, "activeSeason." + Season.FIELD_NUMBER)));
    }

    private void initModelValues() {
        teamCount = teamService.getLeagueTeamsCount(league);
        activeSeason = seasonService.getActiveSeason(league);
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Integer getTeamCount() {
        return teamCount;
    }

    public void setTeamCount(Integer teamCount) {
        this.teamCount = teamCount;
    }

    public Season getActiveSeason() {
        return activeSeason;
    }

    public void setActiveSeason(Season activeSeason) {
        this.activeSeason = activeSeason;
    }
}
