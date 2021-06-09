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

    private static final Logger logger = Logger.getLogger(Controller.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("Controller starts");
        String address = null;
        try {
            address = getAddress(request, response);
        } catch (DBException ex) {
            logger.error("Error with database occurred", ex);
            response.sendRedirect("view/error/error500.jsp");
            logger.debug("Controller finished, redirected to --> view/error/error500.jsp");
        }
        RequestDispatcher disp = request.getRequestDispatcher(address);
        disp.forward(request, response);
        logger.debug("Controller finished, forwarded to --> " + address);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.debug("Controller starts");
        String address;
        try {
            address = getAddress(request, response);
        } catch (DBException ex) {
            logger.error("Error with database occurred", ex);
            address = "view/error/error500.jsp";
        }
        response.sendRedirect(address);
        logger.debug("Controller finished, redirected to --> " + address);
    }

    private String getAddress(HttpServletRequest request, HttpServletResponse response) throws IOException, DBException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String commandName = request.getParameter("command");
        logger.trace("Request parameter: command --> " + commandName);

        Command command;
        try {
            command = CommandContainer.get(commandName);
        } catch (CommandNotFoundException ex) {
            logger.error("Error occurred", ex);
            return "view/error/error404.jsp";
        }
        logger.trace("Obtained command --> " + command);

        String address = command.execute(request, response);
        logger.trace("Address --> " + address);
        return address;
    }

}
