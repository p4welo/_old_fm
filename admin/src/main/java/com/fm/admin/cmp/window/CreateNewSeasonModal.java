package com.fm.admin.cmp.window;

import com.fm.domain.League;
import com.fm.domain.Team;
import com.fm.service.ISeasonService;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 22.02.13
 * Time: 20:49
 * To change this template use File | Settings | File Templates.
 */
public class CreateNewSeasonModal extends AbstractModal
{

   @SpringBean
   private ISeasonService seasonService;

   private League league;

   private List<Team> allTeams;

   private List<Team> selectedTeams;

   public CreateNewSeasonModal(String id, League league, List<Team> allTeams)
   {
      super(id);
      this.league = league;
      this.allTeams = allTeams;
      this.selectedTeams = new ArrayList<Team>();
   }

   @Override
   public void onConfirm(AjaxRequestTarget target)
   {
   }

   @Override
   protected void initView()
   {

//      TextField name = new TextField<String>("name", new PropertyModel(
//              this, "name"));
//      name.setRequired(true);
//      form.add(name);
//      TextField account = new TextField<String>("account", new PropertyModel(
//              this, "account"));
//      account.setRequired(true);
//      form.add(account);
   }

//   public String getName()
//   {
//      return name;
//   }
//
//   public void setName(String name)
//   {
//      this.name = name;
//   }
//
//   public Integer getAccount()
//   {
//      return account;
//   }
//
//   public void setAccount(Integer account)
//   {
//      this.account = account;
//   }
}
