package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.dao.ExhibitionDAO;
import com.koba.exhibitions.dao.exception.DBException;
import com.koba.exhibitions.dao.factory.DAOFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetOrderExhibition implements Command{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws DBException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        DAOFactory factory = DAOFactory.getInstance();
        ExhibitionDAO exhibitionDAO = factory.getExhibitionDAO();
//        OrderExhibition exhibition = exhibitionDAO.getExhibition(id);
//        request.getSession().setAttribute("exhibition", exhibition);
        response.sendRedirect("view/buyTickets.jsp");
    }
}
