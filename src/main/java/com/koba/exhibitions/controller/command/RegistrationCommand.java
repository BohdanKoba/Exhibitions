package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.dao.factory.DAOFactory;
import com.koba.exhibitions.dao.exception.DBException;
import com.koba.exhibitions.dao.AccountDAO;
import com.koba.exhibitions.bean.RegistrationData;
import com.koba.exhibitions.dao.exception.LoginExistsException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationCommand implements Command {
    private static final Logger logger = LogManager.getLogger(RegistrationCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws DBException, IOException, ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        RegistrationData data = new RegistrationData();
        data.setLogin(login);
        data.setPassword(password);
        data.setFirstName(firstName);
        data.setLastName(lastName);
        data.setEmail(email);

        DAOFactory factory = DAOFactory.getInstance();
        AccountDAO accountDAO = factory.getAccountDAO();
        try {
            accountDAO.registerAccount(data);
        } catch (LoginExistsException ex) {
            logger.warn("Could not create new account", ex);
            request.setAttribute("errorMessage", "errorMessage");
            request.getRequestDispatcher("view/registration.jsp").forward(request, response);
            logger.debug("Forwarded to --> signIn.jsp");
            return;
        }
        response.sendRedirect("view/signIn.jsp");
    }

}
