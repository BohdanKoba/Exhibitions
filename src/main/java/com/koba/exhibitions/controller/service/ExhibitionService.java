package com.koba.exhibitions.controller.service;

import com.koba.exhibitions.bean.Account;
import com.koba.exhibitions.bean.Exhibition;
import com.koba.exhibitions.bean.Hall;
import com.koba.exhibitions.controller.dependencyInjection.Context;
import com.koba.exhibitions.dao.ExhibitionDAO;
import com.koba.exhibitions.dao.HallDAO;
import com.koba.exhibitions.dao.exception.DBException;
import com.koba.exhibitions.dao.impl.ExhibitionDAOImpl;
import com.koba.exhibitions.dao.impl.HallDAOImpl;

import javax.servlet.http.HttpSession;
import java.util.List;

public class ExhibitionService {
    public static void getExhibitions(HttpSession session) throws DBException {
        ExhibitionDAO exhibitionDAO = Context.getObject(ExhibitionDAO.class);
        HallDAO hallDAO = Context.getObject(HallDAOImpl.class);

        Account account = (Account) session.getAttribute("account");

        List<Exhibition> exhibitions;
        if (account == null || account.getRole().equals("client")) {
            exhibitions = exhibitionDAO.getAvailableExhibitions();
        } else {
            exhibitions = exhibitionDAO.getAllExhibitions();
        }

        for (Exhibition exhibition : exhibitions) {
            List<Hall> halls = hallDAO.getExhibitionHalls(exhibition.getId());
            exhibition.setExhibitionHalls(halls);
        }

        session.setAttribute("exhibitions", exhibitions);
    }

}
