package com.koba.exhibitions.web.command;

import com.koba.exhibitions.db.dao.DBException;
import com.koba.exhibitions.db.dao.impl.AccountDAOImpl;
import com.koba.exhibitions.db.entity.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {
    private static final long serialVersionUID = -122987195179934623L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("LoginCommand#execute");
        String address = "login.jsp";

        String login = request.getParameter("login");
        System.out.println("login ==> " + login);

        String password = request.getParameter("password");

        AccountDAOImpl accountDAO = new AccountDAOImpl();
        Account account = null;
        try {
            account = accountDAO.authorizeAccount(login, password);
        } catch (DBException e) {
            address = "hello.jsp";
            System.out.println("WRONG LOGIN OR PASSWORD");
        }

        System.out.println("ACCOUNT ==> " + account);

        return address;
    }

}
