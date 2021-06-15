package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.controller.service.ExhibitionService;
import com.koba.exhibitions.dao.exception.DBException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static com.koba.exhibitions.controller.service.ExhibitionService.getExhibitions;

public class GetExhibitionsCommand implements Command {
    private static final Logger logger = LogManager.getLogger(GetExhibitionsCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String referer = request.getHeader("Referer");
        HttpSession session = request.getSession();
        ExhibitionService service = new ExhibitionService();
        try {
            service.getExhibitions(session);
        } catch (DBException ex) {
            logger.error("Error with database occurred", ex);
            request.setAttribute("errorMessage", "errorMessage");
            request.getRequestDispatcher("view/error/error500.jsp").forward(request, response);
            logger.debug("Forwarded to --> error500.jsp");
            return;
        }
        response.sendRedirect(referer);
    }

}
