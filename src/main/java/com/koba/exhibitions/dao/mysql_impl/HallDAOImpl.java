package com.koba.exhibitions.dao.mysql_impl;

import com.koba.exhibitions.bean.Hall;
import com.koba.exhibitions.controller.dependency_injection.Component;
import com.koba.exhibitions.dao.HallDAO;
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
public class HallDAOImpl implements HallDAO {
    private static final Logger logger = LogManager.getLogger(HallDAOImpl.class);

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public List<Hall> getAllHalls() throws DBException {
        List<Hall> halls;

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = connectionPool.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(GET_ALL_HALLS);
            halls = mapHallsList(rs);
            logger.info("List of halls has been successfully obtained");
        } catch (SQLException ex) {
            throw new DBException("Could not obtain a list", ex);
        } finally {
            close(con, stmt, rs);
        }
        return halls;
    }

    @Override
    public List<Hall> getAvailableHalls(String dateFrom, String dateTo) throws DBException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Hall> halls = new ArrayList<>();
        try {
            con = connectionPool.getConnection();
            pstmt = con.prepareStatement(GET_AVAILABLE_HALLS);
            for (int k = 1; k <= 6; k++) {
                pstmt.setString(k++, dateFrom);
                pstmt.setString(k, dateTo);
            }
            rs = pstmt.executeQuery();
            while (rs.next()) {
                halls.add(mapHall(rs));
            }
            logger.info("List of available halls has been successfully obtained");
        } catch (SQLException ex) {
            throw new DBException("Could not obtain a list", ex);
        } finally {
            close(con, pstmt, rs);
        }
        return halls;
    }

    @Override
    public List<Hall> getExhibitionHalls(Integer exhibitionId) throws DBException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Hall> exhibitionHalls = new ArrayList<>();
        try {
            List<Integer> hallsIds = getExhibitionHallsIds(exhibitionId);
            con = connectionPool.getConnection();
            pstmt = con.prepareStatement(GET_HALL_BY_ID);
            for (Integer id : hallsIds) {
                pstmt.setInt(1, id);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    exhibitionHalls.add(mapHall(rs));
                }
            }
            logger.info("List of exhibition halls has been successfully obtained");
        } catch (SQLException ex) {
            throw new DBException("Could not obtain a list", ex);
        } finally {
            close(con, pstmt, rs);
        }
        return exhibitionHalls;
    }

    private List<Integer> getExhibitionHallsIds(Integer exhibitionId) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Integer> hallsIds = new ArrayList<>();
        try {
            con = connectionPool.getConnection();
            pstmt = con.prepareStatement(GET_EXHIBITION_HALLS_ID);
            pstmt.setInt(1, exhibitionId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                hallsIds.add(rs.getInt(EXHIBITION_HALL_COLUMN_HALL_ID));
            }
            logger.info("List of exhibition halls id's has been successfully obtained");
        } finally {
            close(con, pstmt, rs);
        }
        return hallsIds;
    }

    private List<Hall> mapHallsList(ResultSet rs) throws SQLException {
        List<Hall> halls = new ArrayList<>();
        while (rs.next()) {
            Hall hall = mapHall(rs);
            halls.add(hall);
        }
        return halls;
    }

    private Hall mapHall(ResultSet rs) throws SQLException {
        Hall hall = new Hall();

        hall.setId(rs.getInt(COLUMN_ID));
        hall.setHallName(rs.getString(HALL_COLUMN_HALL_NAME));

        return hall;
    }

}
