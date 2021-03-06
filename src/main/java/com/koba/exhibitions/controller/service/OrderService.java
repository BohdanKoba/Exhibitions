package com.koba.exhibitions.controller.service;

import com.koba.exhibitions.bean.Order;
import com.koba.exhibitions.bean.OrderData;
import com.koba.exhibitions.controller.dependency_injection.Component;
import com.koba.exhibitions.controller.dependency_injection.Context;
import com.koba.exhibitions.dao.OrderDAO;
import com.koba.exhibitions.dao.exception.DBException;
import com.koba.exhibitions.dao.mysql_impl.OrderDAOImpl;

import java.util.List;

@Component
public class OrderService {
    private final OrderDAO orderDAO = Context.getObject(OrderDAOImpl.class);

    public void createOrder(OrderData data) throws DBException {
        orderDAO.createOrder(data);
    }

    public List<Order> getOrders(Integer accountId) throws DBException {
        return orderDAO.getOrders(accountId);
    }

}
