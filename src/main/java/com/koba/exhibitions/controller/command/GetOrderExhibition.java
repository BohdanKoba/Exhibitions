package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.bean.Exhibition;
import com.koba.exhibitions.controller.service.ExhibitionService;
import com.koba.exhibitions.dao.exception.DBException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetOrderExhibition implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws DBException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));

        ExhibitionService exhibitionService = new ExhibitionService();
        Exhibition exhibition = exhibitionService.getExhibition(id);
        request.setAttribute("exhibition", exhibition);
        request.getRequestDispatcher("view/client/buyTickets.jsp").forward(request, response);
    }

}
