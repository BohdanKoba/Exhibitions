package com.koba.exhibitions.web.command;

import com.koba.exhibitions.db.dao.util.DBException;
import com.koba.exhibitions.db.dao.factory.DAOFactory;
import com.koba.exhibitions.db.dao.AccountDAO;
import com.koba.exhibitions.db.bean.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.koba.exhibitions.web.Service.getExhibitions;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        DAOFactory factory = DAOFactory.getInstance();
        AccountDAO accountDAO = factory.getAccountDAO();
        Account account;
        try {
            account = accountDAO.authorizeAccount(login, password);
        } catch (DBException e) {
//            request.setAttribute("errorMessage", "Wrong login or password");
            return "login.jsp";
        }

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(-1);
        session.setAttribute("account", account);
        System.out.println("Login command => " + account);
        getExhibitions(session);
        return "main.jsp";
    }

}
