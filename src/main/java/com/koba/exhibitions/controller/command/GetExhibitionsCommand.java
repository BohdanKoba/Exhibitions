package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.bean.Account;
import com.koba.exhibitions.bean.Exhibition;
import com.koba.exhibitions.controller.service.GetExhibitionsService;
import com.koba.exhibitions.dao.exception.DBException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

public class GetExhibitionsCommand implements Command {
    private static final Logger logger = LogManager.getLogger(GetExhibitionsCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");

        GetExhibitionsService getExhService = new GetExhibitionsService();
        try {
            List<Exhibition> exhibitions = getExhService.getExhibitions(account);
            session.setAttribute("exhibitions", exhibitions);
        } catch (DBException ex) {
            logger.error("Error with database occurred", ex);
            request.getRequestDispatcher("view/error/error500.jsp").forward(request, response);
            logger.debug("Forwarded to --> error500.jsp");
            return;
        }
        request.getRequestDispatcher("view/exhibitions.jsp").forward(request, response);
    }

}
