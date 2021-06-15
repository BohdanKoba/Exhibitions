package com.koba.exhibitions.controller.service;

import com.koba.exhibitions.bean.Order;
import com.koba.exhibitions.controller.dependencyInjection.Context;
import com.koba.exhibitions.dao.exception.DBException;
import com.koba.exhibitions.dao.impl.ExhibitionDAOImpl;
import com.koba.exhibitions.dao.impl.HallDAOImpl;
import com.koba.exhibitions.dao.impl.OrderDAOImpl;

import java.util.List;

public class AccountOrdersService {
    public void getAccountOrders(int accountId) throws DBException {
        OrderDAOImpl orderDAO = Context.getObject(OrderDAOImpl.class);
        ExhibitionDAOImpl exhibitionDAO = Context.getObject(ExhibitionDAOImpl.class);
        HallDAOImpl hallDAO = Context.getObject(HallDAOImpl.class);

        List<Order> orders = orderDAO.getOrders(accountId);



    }

}
