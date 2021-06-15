package com.koba.exhibitions.controller.service;

import com.koba.exhibitions.bean.Order;
import com.koba.exhibitions.bean.OrderData;
import com.koba.exhibitions.controller.dependencyInjection.Context;
import com.koba.exhibitions.dao.OrderDAO;
import com.koba.exhibitions.dao.exception.DBException;
import com.koba.exhibitions.dao.impl.OrderDAOImpl;

import java.util.List;

public class OrderService {
    public void createOrder(OrderData data) throws DBException {
        OrderDAO orderDAO = Context.getObject(OrderDAOImpl.class);
        orderDAO.createOrder(data);
    }

    public List<Order> getOrders(Integer accountId) throws DBException {
        OrderDAOImpl orderDAO = Context.getObject(OrderDAOImpl.class);
        return orderDAO.getOrders(accountId);
    }

}
