package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.bean.Exhibition;
import com.koba.exhibitions.dao.ExhibitionDAO;
import com.koba.exhibitions.dao.factory.DAOFactory;
import com.koba.exhibitions.dao.exception.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChangeStatusCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws DBException, IOException {
        String referer = request.getHeader("Referer");
        DAOFactory factory = DAOFactory.getInstance();
        ExhibitionDAO exhibitionDAO = factory.getExhibitionDAO();

        int id = Integer.parseInt(request.getParameter("exhibitionId"));
        String status = "active";
        Exhibition exhibition = exhibitionDAO.getExhibition(id);
        if (exhibition.getStatus().equals("active")) {
            status = "canceled";
        }
        HttpSession session = request.getSession();
        exhibitionDAO.updateExhibitionStatus(id, status);
        session.removeAttribute("exhibitions");
        response.sendRedirect(referer);
    }

}
