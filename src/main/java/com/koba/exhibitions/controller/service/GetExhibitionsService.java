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

import java.util.List;

public class GetExhibitionsService {
    private final ExhibitionDAO exhibitionDAO = Context.getObject(ExhibitionDAOImpl.class);
    private final HallDAO hallDAO = Context.getObject(HallDAOImpl.class);

    public List<Exhibition> getExhibitions(Account account) throws DBException {
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
        return exhibitions;
    }
}
