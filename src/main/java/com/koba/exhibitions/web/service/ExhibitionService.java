package com.koba.exhibitions.web.service;

import com.koba.exhibitions.db.bean.Account;
import com.koba.exhibitions.db.bean.Exhibition;
import com.koba.exhibitions.db.dao.ExhibitionDAO;
import com.koba.exhibitions.db.dao.factory.DAOFactory;
import com.koba.exhibitions.db.dao.util.DBException;

import javax.servlet.http.HttpSession;
import java.util.List;

public class ExhibitionService {
    public static void getExhibitions(HttpSession session) throws DBException {
        DAOFactory factory = DAOFactory.getInstance();
        ExhibitionDAO exhibitionDAO = factory.getExhibitionDAO();

        Account account = (Account) session.getAttribute("account");
        List<Exhibition> exhibitions;
        if (account == null || account.getRole().equals("client")) {
            exhibitions = exhibitionDAO.getAvailableExhibitions();
        } else {
            exhibitions = exhibitionDAO.getAllExhibitions();
        }
        session.setAttribute("exhibitions", exhibitions);
    }

}
