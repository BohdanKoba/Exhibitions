package com.koba.exhibitions;

import com.koba.exhibitions.web.command.Command;
import com.koba.exhibitions.web.command.CommandContainer;
import com.koba.exhibitions.db.dao.DBException;
import org.apache.log4j.Logger;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/controller")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = -3956835999223981428L;

    private static final Logger log = Logger.getLogger(Controller.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    /**
     * Main method of this controller.
     */
    private void process(HttpServletRequest request,
                         HttpServletResponse response) throws IOException, ServletException {

        log.debug("Controller starts");

        // extract command name from the request
        String commandName = request.getParameter("command");
        log.trace("Request parameter: command --> " + commandName);

        // obtain command object by its name
        Command command = CommandContainer.get(commandName);
        log.trace("Obtained command --> " + command);

        // execute command and get forward address
        String forward = null;
        try {
            forward = command.execute(request, response);
        } catch (DBException e) {
            e.printStackTrace();
        }
        log.trace("Forward address --> " + forward);

        log.debug("Controller finished, now go to forward address --> " + forward);

        // if the forward address is not null go to the address
        if (forward != null) {
            RequestDispatcher disp = request.getRequestDispatcher(forward);
            disp.forward(request, response);
        }
    }

}