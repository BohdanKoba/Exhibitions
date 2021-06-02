package com.koba.exhibitions.web;

import com.koba.exhibitions.db.bean.Account;
import com.koba.exhibitions.db.bean.Exhibition;
import com.koba.exhibitions.db.dao.impl.ExhibitionDAOImpl;
import com.koba.exhibitions.db.dao.util.DBException;

import javax.servlet.http.HttpSession;
import java.util.List;

public class Service {
    public static void getExhibitions(HttpSession session) {
        ExhibitionDAOImpl exhibitionDAO = new ExhibitionDAOImpl();
        Account account = (Account)session.getAttribute("account");
        List<Exhibition> exhibitions = null;
        System.out.println("Service command => " + account);
        try {
            if (account == null || account.getRole().equals("client")) {
                exhibitions = exhibitionDAO.getAvailableExhibitions();
                System.out.println("Available");
            } else {
                exhibitions = exhibitionDAO.getAllExhibitions();
                System.out.println("All");
            }
            System.out.println("WORKS !!!!!!!!!!!!!!!!!!!!!!!!!");
        }catch (DBException e) {
            System.out.println("ERRRRRRRRRRRRRRROR");
            e.printStackTrace(); //TODO do something
        }
        session.setAttribute("exhibitionsList", exhibitions);
    }

}
