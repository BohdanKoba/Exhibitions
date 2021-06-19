package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.bean.Exhibition;
import com.koba.exhibitions.controller.service.AccountService;
import com.koba.exhibitions.controller.service.GetExhibitionsService;
import com.koba.exhibitions.dao.exception.AuthorizationException;
import com.koba.exhibitions.dao.exception.DBException;
import com.koba.exhibitions.bean.Account;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

public class SignInCommand implements Command {
    private static final Logger logger = LogManager.getLogger(SignInCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws DBException, ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        AccountService accountService = new AccountService();
        Account account;
        try {
            account = accountService.authorizeAccount(login, password);
        } catch (AuthorizationException ex) {
            logger.warn("Could not authorize account: " + ex.getMessage());
            request.setAttribute("errorMessage", "errorMessage");
            request.getRequestDispatcher("view/signIn.jsp").forward(request, response);
            logger.debug("Forwarded to --> signIn.jsp");
            return;
        }
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(-1);
        session.setAttribute("account", account);
        GetExhibitionsService exhibitionService = new GetExhibitionsService();
        List<Exhibition> exhibitions = exhibitionService.getExhibitions(account);
        request.getSession().setAttribute("exhibitions", exhibitions);
        response.sendRedirect("view/index.jsp");
    }

}
