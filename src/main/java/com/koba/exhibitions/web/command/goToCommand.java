package com.koba.exhibitions.web.command;

import com.koba.exhibitions.db.bean.Exhibition;
import com.koba.exhibitions.db.dao.ExhibitionDAO;
import com.koba.exhibitions.db.dao.factory.DAOFactory;
import com.koba.exhibitions.db.dao.util.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class goToCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws DBException {
        DAOFactory factory = DAOFactory.getInstance();
        ExhibitionDAO exhibitionDAO = factory.getExhibitionDAO();
        int id = Integer.parseInt(request.getParameter("exhibition"));
        Exhibition exhibition = exhibitionDAO.getExhibition(id);
        request.getSession().setAttribute("exhibition", exhibition);
        return "editExhibition.jsp";
    }

}
