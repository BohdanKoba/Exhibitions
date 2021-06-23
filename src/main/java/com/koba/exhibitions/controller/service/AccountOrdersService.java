package com.koba.exhibitions.controller.service;

import com.koba.exhibitions.bean.Order;
import com.koba.exhibitions.controller.dependency_injection.Component;
import com.koba.exhibitions.controller.dependency_injection.Context;
import com.koba.exhibitions.dao.exception.DBException;
import com.koba.exhibitions.dao.mysql_impl.ExhibitionDAOImpl;
import com.koba.exhibitions.dao.mysql_impl.HallDAOImpl;
import com.koba.exhibitions.dao.mysql_impl.OrderDAOImpl;

import java.util.List;

@Component
public class AccountOrdersService {
    public void getAccountOrders(int accountId) throws DBException {
        OrderDAOImpl orderDAO = Context.getObject(OrderDAOImpl.class);
        ExhibitionDAOImpl exhibitionDAO = Context.getObject(ExhibitionDAOImpl.class);
        HallDAOImpl hallDAO = Context.getObject(HallDAOImpl.class);

        List<Order> orders = orderDAO.getOrders(accountId);



    }

}
