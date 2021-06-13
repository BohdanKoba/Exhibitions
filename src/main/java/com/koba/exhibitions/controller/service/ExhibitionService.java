package com.koba.exhibitions.controller.service;

import com.koba.exhibitions.bean.Account;
import com.koba.exhibitions.bean.Exhibition;
import com.koba.exhibitions.bean.Hall;
import com.koba.exhibitions.dao.ExhibitionDAO;
import com.koba.exhibitions.dao.HallDAO;
import com.koba.exhibitions.dao.exception.DBException;
import com.koba.exhibitions.dao.factory.DAOFactory;

import javax.servlet.http.HttpSession;
import java.util.List;

public class ExhibitionService {
    public static void getExhibitions(HttpSession session) throws DBException {
        DAOFactory factory = DAOFactory.getInstance();
        ExhibitionDAO exhibitionDAO = factory.getExhibitionDAO();
        HallDAO hallDAO = factory.getHallDAO();

        Account account = (Account) session.getAttribute("account");

        List<Exhibition> exhibitions;
        if (account == null || account.getRole().equals("client")) {
            exhibitions = exhibitionDAO.getAvailableExhibitions();
        } else {
            exhibitions = exhibitionDAO.getAllExhibitions();
        }

//        for (Exhibition exhibition : exhibitions) {
//            System.out.println("OK");
//            List<Integer> hallId = hallDAO.getExhibitionHalls(exhibition.getId());
//            List<Hall> halls = null;
//            for (Integer id: hallId) {
//                Hall hall = hallDAO.getHall(id);
//                halls.add(hall);
//            }
//            exhibition.setExhibitionHalls(halls);
//        }

        session.setAttribute("exhibitions", exhibitions);
    }

}
