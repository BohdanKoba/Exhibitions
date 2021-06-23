package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.bean.ExhibitionData;
import com.koba.exhibitions.controller.dependency_injection.Context;
import com.koba.exhibitions.controller.service.ExhibitionService;
import com.koba.exhibitions.dao.exception.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddExhibitionCommand implements Command {
    private final ExhibitionService exhibitionService = Context.getObject(ExhibitionService.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws DBException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String dateFrom = request.getParameter("dateFrom");
        String dateTo = request.getParameter("dateTo");
        String timeFrom = request.getParameter("timeFrom");
        String timeTo = request.getParameter("timeTo");

        ExhibitionData data = new ExhibitionData(title, description, price, dateFrom, dateTo, timeFrom, timeTo);
        exhibitionService.addExhibition(data);
        response.sendRedirect("view/admin/addExhibition.jsp");
    }

}
