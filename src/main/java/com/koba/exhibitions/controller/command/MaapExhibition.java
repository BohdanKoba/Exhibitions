package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.bean.Exhibition;
import com.koba.exhibitions.dao.ExhibitionDAO;
import com.koba.exhibitions.dao.exception.DBException;
import com.koba.exhibitions.dao.factory.DAOFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MaapExhibition implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws DBException {
        int id = Integer.parseInt(request.getParameter("id"));

        DAOFactory factory = DAOFactory.getInstance();
        ExhibitionDAO exhibitionDAO = factory.getExhibitionDAO();
        Exhibition exhibition = exhibitionDAO.getExhibition(id);
        request.getSession().setAttribute("exhibition", exhibition);
        return "view/buyTickets.jsp";
    }
}
