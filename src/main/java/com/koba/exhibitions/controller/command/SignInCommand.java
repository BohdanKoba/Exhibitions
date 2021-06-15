package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.controller.service.AccountService;
import com.koba.exhibitions.controller.service.ExhibitionService;
import com.koba.exhibitions.dao.exception.AuthorizationException;
import com.koba.exhibitions.dao.exception.DBException;
import com.koba.exhibitions.dao.factory.DAOFactory;
import com.koba.exhibitions.dao.AccountDAO;
import com.koba.exhibitions.bean.Account;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class SignInCommand implements Command {
    private static final Logger logger = LogManager.getLogger(SignInCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws DBException, ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        AccountService service = new AccountService();
        Account account;
        try {
            account = service.authorizeAccount(login, password);
        } catch (AuthorizationException ex) {
            logger.warn("Could not authorize account", ex);
            request.setAttribute("errorMessage", "errorMessage");
            request.getRequestDispatcher("view/signIn.jsp").forward(request, response);
            logger.debug("Forwarded to --> signIn.jsp");
            return;
        }
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(-1);
        session.setAttribute("account", account);
        if (account.getRole().equals("admin")) {
            ExhibitionService exhibitionService = new ExhibitionService();
            exhibitionService.getExhibition(account.getId());
        }
        response.sendRedirect("view/index.jsp");
    }

}
