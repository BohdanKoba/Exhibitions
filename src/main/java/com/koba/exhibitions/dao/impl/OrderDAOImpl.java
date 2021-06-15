package com.koba.exhibitions.dao.impl;

import com.koba.exhibitions.bean.Order;
import com.koba.exhibitions.bean.OrderData;
import com.koba.exhibitions.controller.dependencyInjection.Component;
import com.koba.exhibitions.dao.OrderDAO;
import com.koba.exhibitions.dao.connection.ConnectionPool;
import com.koba.exhibitions.dao.exception.DBException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.koba.exhibitions.dao.connection.ConnectionPool.close;
import static com.koba.exhibitions.dao.constant.Fields.*;
import static com.koba.exhibitions.dao.constant.SQLQueries.*;

@Component
public class OrderDAOImpl implements OrderDAO {
    private static final Logger logger = LogManager.getLogger(OrderDAOImpl.class);

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void createOrder(OrderData data) throws DBException {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = connectionPool.getConnection();
            pstmt = con.prepareStatement(CREATE_ORDER);
            int k = 1;
            pstmt.setInt(k++, data.getAccountId());
            pstmt.setInt(k++, data.getExhibitionId());
            pstmt.setShort(k++, data.getQuantity());
            pstmt.setInt(k++, data.getBill());
            pstmt.executeUpdate();
            logger.info("New order has been successfully created");
        } catch (SQLException ex) {
            logger.error("Severe problem with database occurred", ex);
            throw new DBException("Could not create new order", ex);
        } finally {
            close(con, pstmt);
        }
    }

    @Override
    public List<Order> getOrders(Integer accountId) throws DBException {
        List<Order> orders;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = connectionPool.getConnection();
            pstmt = con.prepareStatement(GET_ACCOUNT_ORDERS);
            pstmt.setInt(1, accountId);
            rs = pstmt.executeQuery();
            if (!rs.next()) {
                throw new SQLException();
            }
            orders = mapOrdersList(rs);
            logger.info("List of orders has been successfully obtained");
        } catch (SQLException ex) {
            logger.error("Severe problem with database occurred", ex);
            throw new DBException("Could not obtain a list", ex);
        } finally {
            close(con, pstmt, rs);
        }
        return orders;
    }

    private List<Order> mapOrdersList(ResultSet rs) throws SQLException {
        List<Order> orders = new ArrayList<>();
        while (rs.next()) {
            Order order = mapOrder(rs);
            orders.add(order);
        }
        return orders;
    }

    private Order mapOrder(ResultSet rs) throws SQLException {
        Order order = new Order();

        order.setId(rs.getInt(COLUMN_ID));
        order.setAccountId(rs.getInt(ACCOUNT_ORDER_COLUMN_ACCOUNT_ID));
        order.setExhibitionId(rs.getInt(ACCOUNT_ORDER_COLUMN_EXHIBITION_ID));
        order.setQuantity(rs.getShort(ACCOUNT_ORDER_COLUMN_QUANTITY));
        order.setExhibitionId(rs.getInt(ACCOUNT_ORDER_COLUMN_BILL));

        return order;
    }

}
