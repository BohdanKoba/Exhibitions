package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.bean.Account;
import com.koba.exhibitions.bean.Exhibition;
import com.koba.exhibitions.dao.ExhibitionDAO;
import com.koba.exhibitions.dao.exception.DBException;
import com.koba.exhibitions.dao.factory.DAOFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.koba.exhibitions.controller.service.ExhibitionService.getExhibitions;

public class AddToCartCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws DBException {
        String referer = request.getHeader("Referer");
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        if (account == null) {
            return "signIn.jsp";
        } else {
            int id = Integer.parseInt(request.getParameter("exhibitionId"));
            DAOFactory factory = DAOFactory.getInstance();
            ExhibitionDAO exhibitionDAO = factory.getExhibitionDAO();
            Exhibition exhibition = exhibitionDAO.getExhibition(id);
            System.out.println(exhibition.getStatus());
            if (exhibition.getStatus().equals("canceled")) {
                getExhibitions(session);
                return "jsp/error/error500.jsp";
            }
            //TODO add to card impl !!!!!!!!!!!!!
        }
        return referer;
    }

}
