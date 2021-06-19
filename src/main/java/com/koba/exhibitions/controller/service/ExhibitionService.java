package com.koba.exhibitions.controller.service;

import com.koba.exhibitions.bean.Exhibition;
import com.koba.exhibitions.bean.ExhibitionData;
import com.koba.exhibitions.bean.Hall;
import com.koba.exhibitions.controller.dependencyInjection.Context;
import com.koba.exhibitions.dao.ExhibitionDAO;
import com.koba.exhibitions.dao.exception.DBException;
import com.koba.exhibitions.dao.impl.ExhibitionDAOImpl;

import java.util.List;

public class ExhibitionService {
    private final ExhibitionDAO exhibitionDAO = Context.getObject(ExhibitionDAOImpl.class);

    public void changeExhibitionStatus(int id) throws DBException {
        String status = "active";
        Exhibition exhibition = exhibitionDAO.getExhibition(id);
        if (exhibition.getStatus().equals("active")) {
            status = "canceled";
        }
        exhibitionDAO.updateExhibitionStatus(id, status);
    }

    public Exhibition getExhibition(Integer exhibitionId) throws DBException {
        return exhibitionDAO.getExhibition(exhibitionId);
    }

    public void addExhibition(ExhibitionData data, List<Hall> halls) throws DBException {

    }

}
