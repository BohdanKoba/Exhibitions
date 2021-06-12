package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.bean.Account;
import com.koba.exhibitions.dao.exception.DBException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToCommand implements Command {
    private static final Logger logger = Logger.getLogger(GoToCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws DBException, IOException {
        Account account = (Account) request.getSession().getAttribute("account");
        String address = request.getParameter("address");
        if (account == null && (address.equals("view/buyTickets.jsp") || address.equals("view/home.jsp"))) {
            response.sendRedirect("view/signIn.jsp");
        } else {
            response.sendRedirect(address);
        }
        logger.trace("Page address --> " + address);
    }

}
