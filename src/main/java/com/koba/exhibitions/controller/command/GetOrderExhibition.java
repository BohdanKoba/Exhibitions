package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.bean.Exhibition;
import com.koba.exhibitions.controller.service.ExhibitionService;
import com.koba.exhibitions.dao.exception.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetOrderExhibition implements Command{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws DBException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ExhibitionService service = new ExhibitionService();
        Exhibition exhibition = service.getExhibition(id);
        request.getSession().setAttribute("exhibition", exhibition);
        response.sendRedirect("view/buyTickets.jsp");
    }

}
