package com.fm.admin.cmp.leagueDetailsPage.window;

import com.fm.core.cmp.window.AbstractModal;
import com.fm.domain.League;
import com.fm.domain.Team;
import com.fm.service.ITeamService;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 22.02.13
 * Time: 20:49
 * To change this template use File | Settings | File Templates.
 */
public class CreateNewTeamModal extends AbstractModal
{

   @SpringBean
   private ITeamService teamService;

   private String name;

   private Integer account;

   private League league;

   public CreateNewTeamModal(String id, League league)
   {
      super(id);
      this.league = league;
   }

   @Override
   public void onConfirm(AjaxRequestTarget target)
   {
      Team team = new Team();
      team.setName(name);
      team.setAccount(account);
      team.setLeague(league);
      teamService.save(team);
   }

   @Override
   protected void initView()
   {
      TextField name = new TextField<String>("name", new PropertyModel(
              this, "name"));
      name.setRequired(true);
      form.add(name);
      TextField account = new TextField<String>("account", new PropertyModel(
              this, "account"));
      account.setRequired(true);
      form.add(account);
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public Integer getAccount()
   {
      return account;
   }

   public void setAccount(Integer account)
   {
      this.account = account;
   }
}
