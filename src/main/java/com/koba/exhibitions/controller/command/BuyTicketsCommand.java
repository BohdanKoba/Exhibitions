package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.bean.Account;
import com.koba.exhibitions.bean.Exhibition;
import com.koba.exhibitions.dao.ExhibitionDAO;
import com.koba.exhibitions.dao.exception.DBException;
import com.koba.exhibitions.dao.factory.DAOFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BuyTicketsCommand implements Command {
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
            if (exhibition.getStatus().equals("canceled")) {
                session.removeAttribute("exhibitions");
                throw new DBException("Can't buy tickets. Exhibition cancelled.");
            }
            //TODO add to card impl !!!!!!!!!!!!!
        }
        return referer;
    }

}
