package com.koba.exhibitions.controller;

import com.koba.exhibitions.dao.exception.DBException;
import com.koba.exhibitions.controller.command.Command;
import com.koba.exhibitions.controller.command.CommandContainer;
import com.koba.exhibitions.controller.command.exception.CommandNotFoundException;
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

        Command command;
        try {
            command = CommandContainer.get(commandName);
        } catch (CommandNotFoundException ex) {
            log.error("Error occurred", ex);
            return "/jsp/error/error404.jsp";
        }
        log.trace("Obtained command --> " + command);

        String address;
        try {
            address = command.execute(request, response);
        } catch (DBException ex) {
            log.error("Error occurred", ex);
            return "/jsp/error/error500.jsp";
        }
        log.trace("Address --> " + address);
        return address;
    }

}
