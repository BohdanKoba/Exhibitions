package com.koba.exhibitions.controller.service;

import com.koba.exhibitions.bean.Hall;
import com.koba.exhibitions.controller.dependency_injection.Component;
import com.koba.exhibitions.controller.dependency_injection.Context;
import com.koba.exhibitions.dao.HallDAO;
import com.koba.exhibitions.dao.mysql_impl.HallDAOImpl;
import com.koba.exhibitions.dao.exception.DBException;

import java.util.List;

@Component
public class HallService {
    private final HallDAO hallDAO = Context.getObject(HallDAOImpl.class);

    public List<Hall> getAvailableHalls(String dateFrom, String dateTo) throws DBException {
        return hallDAO.getAvailableHalls(dateFrom, dateTo);
    }

}
