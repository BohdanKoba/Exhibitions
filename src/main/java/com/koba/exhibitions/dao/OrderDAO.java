package com.koba.exhibitions.dao;

import com.koba.exhibitions.bean.Order;
import com.koba.exhibitions.bean.OrderData;
import com.koba.exhibitions.dao.exception.DBException;

import java.util.List;

public interface OrderDAO {

    void createOrder(OrderData data) throws DBException;

    List<Order> getOrders(Integer accountId) throws DBException;

}
