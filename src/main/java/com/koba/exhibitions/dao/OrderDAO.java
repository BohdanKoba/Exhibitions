package com.koba.exhibitions.dao;

import com.koba.exhibitions.bean.Order;
import com.koba.exhibitions.dao.exception.DBException;

import java.util.List;
import java.util.Map;

public interface OrderDAO {

    Integer createOrder(Integer accountId) throws DBException;

    void updateOrderStatus(Integer id) throws DBException;

    List<Order> getOrders(Integer accountId) throws DBException;

}
