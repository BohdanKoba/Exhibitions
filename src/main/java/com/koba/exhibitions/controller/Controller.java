package com.koba.exhibitions.controller;

import com.koba.exhibitions.dao.exception.DBException;
import com.koba.exhibitions.controller.command.Command;
import com.koba.exhibitions.controller.command.CommandContainer;
import com.koba.exhibitions.controller.command.exception.CommandNotFoundException;
import org.apache.log4j.Logger;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Controller extends HttpServlet {
    private static final long serialVersionUID = -3956835999223981428L;

    private static final Logger logger = Logger.getLogger(Controller.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.debug("========Controller starts========");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String commandName = request.getParameter("command");
        logger.trace("Request parameter: command --> " + commandName);
        try {
            Command command = CommandContainer.get(commandName);
            logger.debug("Obtained command --> " + command);
            try {
                command.execute(request, response);
            } catch (DBException ex) {
                logger.error("Severe problem with database occurred", ex);
                response.sendRedirect("view/error/error500.jsp");
                logger.debug("redirected to --> error500.jsp");
            }
            logger.debug("Command executed");
        } catch (CommandNotFoundException ex) {
            logger.error("Error occurred", ex);
            response.sendRedirect("view/error/error404.jsp");
            logger.debug("redirected to --> error404.jsp");
        }
        logger.debug("========Controller finished========");
    }

}
