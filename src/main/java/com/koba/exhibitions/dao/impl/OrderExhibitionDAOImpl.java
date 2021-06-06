package com.koba.exhibitions.dao.impl;

import com.koba.exhibitions.bean.Exhibition;
import com.koba.exhibitions.dao.OrderExhibitionDAO;
import com.koba.exhibitions.dao.exception.DBException;

import java.util.List;

public class OrderExhibitionDAOImpl implements OrderExhibitionDAO {

    @Override
    public Exhibition getOrderExhibitions() throws DBException {
        return null;
    }

    @Override
    public List<List<Exhibition>> addOrderExhibition(Integer orderId, Integer exhibitionId, Integer count) throws DBException {
        return null;
    }

    @Override
    public List<List<Exhibition>> deleteOrderExhibition(Integer orderId) throws DBException {
        return null;
    }
}
