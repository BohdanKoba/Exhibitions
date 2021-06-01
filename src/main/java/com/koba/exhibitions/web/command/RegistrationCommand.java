package com.koba.exhibitions.web.command;

import com.koba.exhibitions.db.dao.factory.DAOFactory;
import com.koba.exhibitions.db.dao.util.DBException;
import com.koba.exhibitions.db.dao.AccountDAO;
import com.koba.exhibitions.db.bean.RegistrationData;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationCommand implements Command{
    private static final Logger logger = LogManager.getLogger(RegistrationCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("RegistrationCommand started");

        String address = "main.jsp";

        String login = request.getParameter("login");
        System.out.println("login ==> " + login);

        String password = request.getParameter("password");
        System.out.println("pass ==> " + password);

        String first_name = request.getParameter("first_name");
        System.out.println("first_name ==> " + first_name);

        String last_name = request.getParameter("last_name");
        System.out.println("last_name ==> " + last_name);

        String email = request.getParameter("email");
        System.out.println("email ==> " + email);

        RegistrationData data = new RegistrationData();
        data.setLogin(login);
        data.setPassword(password);
        data.setFirstName(first_name);
        data.setLastName(last_name);
        data.setEmail(email);

        DAOFactory factory = DAOFactory.getInstance();
        AccountDAO accountDAO = factory.getAccountDAO();

        try {
            accountDAO.registerAccount(data);
        } catch (DBException e) {
            address = "registration.jsp";
            logger.info("Account with login \"" + login +"\" is already exists");
        }

        logger.debug("RegistrationCommand finished");
        return address;
    }

}
