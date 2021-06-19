package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.dao.exception.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddExhibitionCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws DBException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        String dateFrom = request.getParameter("dateFrom");
        String dateTo = request.getParameter("dateTo");
        String timeFrom = request.getParameter("timeFrom");
        String timeTo = request.getParameter("timeTo");
        response.sendRedirect("view/admin/addExhibition.jsp");
    }

}
