package com.koba.exhibitions.dao.impl;

import com.koba.exhibitions.bean.Order;
import com.koba.exhibitions.dao.OrderDAO;
import com.koba.exhibitions.dao.exception.DBException;

import java.util.List;
import java.util.Map;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public Integer createOrder(Integer accountId) throws DBException {
        return null;
    }

    @Override
    public void updateOrderStatus(Integer id) throws DBException {
    }

    @Override
    public List<Order> getOrders(Integer accountId) throws DBException {
        return null;
    }

}
