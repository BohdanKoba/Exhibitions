package com.koba.exhibitions.web.command;

import com.koba.exhibitions.db.dao.util.AuthorizationException;
import com.koba.exhibitions.db.dao.util.DBException;
import com.koba.exhibitions.db.dao.factory.DAOFactory;
import com.koba.exhibitions.db.dao.AccountDAO;
import com.koba.exhibitions.db.bean.Account;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignInCommand implements Command {
    private static final Logger logger = LogManager.getLogger(SignInCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws DBException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        DAOFactory factory = DAOFactory.getInstance();
        AccountDAO accountDAO = factory.getAccountDAO();
        Account account;
        try {
            account = accountDAO.authorizeAccount(login, password);
        } catch (AuthorizationException ex) {
            logger.warn("Could not authorize account", ex);
            // TODO write "wrong login or pass"
            return "signIn.jsp";
        }
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(-1);
        session.setAttribute("account", account);
        session.setAttribute("signedIn", true);
        return "index.jsp";
    }

}
