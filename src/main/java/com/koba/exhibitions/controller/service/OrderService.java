package com.koba.exhibitions.controller.service;

import com.koba.exhibitions.bean.OrderData;
import com.koba.exhibitions.controller.dependencyInjection.Context;
import com.koba.exhibitions.dao.exception.DBException;
import com.koba.exhibitions.dao.impl.OrderDAOImpl;

public class OrderService {
    public void createOrder(OrderData data) throws DBException {
        OrderDAOImpl orderDAO = Context.getObject(OrderDAOImpl.class);
        orderDAO.createOrder(data);
    }

}
