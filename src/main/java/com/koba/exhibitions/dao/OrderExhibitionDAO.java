package com.koba.exhibitions.dao;

import com.koba.exhibitions.bean.Exhibition;
import com.koba.exhibitions.dao.exception.DBException;

import java.util.List;

public interface OrderExhibitionDAO {
    Exhibition getOrderExhibitions() throws DBException;

    List<List<Exhibition>> addOrderExhibition(Integer orderId, Integer exhibitionId, Integer count) throws DBException;

    List<List<Exhibition>> deleteOrderExhibition(Integer orderId) throws DBException;

}
