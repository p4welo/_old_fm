package com.football.manager.admin;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 22.02.13
 * Time: 21:54
 * To change this template use File | Settings | File Templates.
 */
public class AdminSession extends AuthenticatedWebSession {
    private String userName;

    public AdminSession(Request request) {
        super(request);
    }

    @Override
    public boolean authenticate(String userName, String password) {
        boolean success = userName.equals("guest") && password.equals("guest");

        if ( success )
            this.userName = userName;

        return success;
    }

    @Override
    public Roles getRoles() {
        Roles roles = new Roles();

        if ( isSignedIn() )
            roles.add("ROOT");

        return roles;
    }

    public String getUserName() {
        return userName;
    }
}
