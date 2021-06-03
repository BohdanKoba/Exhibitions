package com.koba.exhibitions;

import com.koba.exhibitions.db.dao.util.DBException;
import com.koba.exhibitions.web.command.Command;
import com.koba.exhibitions.web.command.CommandContainer;
import org.apache.log4j.Logger;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Controller extends HttpServlet {
    private static final long serialVersionUID = -3956835999223981428L;

    private static final Logger log = Logger.getLogger(Controller.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("Controller starts");
        String address = getAddress(request, response);
        RequestDispatcher disp = request.getRequestDispatcher(address);
        disp.forward(request, response);
        log.debug("Controller finished, forwarded to--> " + address);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.debug("Controller starts");
        String address = getAddress(request, response);
        response.sendRedirect(address);
        log.debug("Controller finished, redirected to --> " + address);
    }

    private String getAddress(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String commandName = request.getParameter("command");
        log.trace("Request parameter: command --> " + commandName);

        Command command = CommandContainer.get(commandName);
        log.trace("Obtained command --> " + command);

        String address = null;
        try {
            address = command.execute(request, response);
        } catch (DBException e) {
            e.printStackTrace();
            // TODO  redirect to error page 500 !!!!!!!!!!!!!!!!!!!
        }
        log.trace("Address --> " + address);

        return address;
    }

}
