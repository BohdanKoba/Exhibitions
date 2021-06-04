package com.koba.exhibitions.web.command;

import com.koba.exhibitions.db.bean.Exhibition;
import com.koba.exhibitions.db.dao.ExhibitionDAO;
import com.koba.exhibitions.db.dao.factory.DAOFactory;
import com.koba.exhibitions.db.dao.util.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeStatusCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws DBException {
        String referer = request.getHeader("Referer");
        DAOFactory factory = DAOFactory.getInstance();
        ExhibitionDAO exhibitionDAO = factory.getExhibitionDAO();

        int id = Integer.parseInt(request.getParameter("exhibitionId"));
        String status = "active";
        Exhibition exhibition = exhibitionDAO.getExhibition(id);
        if (exhibition.getStatus().equals("active")) {
            status = "canceled";
        }
        exhibitionDAO.updateExhibitionStatus(id, status);
        return referer;
    }

}
