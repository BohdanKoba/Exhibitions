package com.koba.exhibitions.dao.impl;

import com.koba.exhibitions.bean.Hall;
import com.koba.exhibitions.controller.dependencyInjection.Component;
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
    public List<Hall> getExhibitionHalls(Integer exhibitionId) throws DBException {
        List<Hall> exhibitionHalls = new ArrayList<>();

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ResultSet rs2;
        try {
            con = connectionPool.getConnection();
            pstmt = con.prepareStatement(GET_EXHIBITION_HALLS_ID);
            pstmt.setInt(1, exhibitionId);
            rs = pstmt.executeQuery();
            pstmt = con.prepareStatement(GET_HALL_BY_ID);
            while (rs.next()) {
                pstmt.setInt(1, rs.getInt(EXHIBITION_HALL_COLUMN_HALL_ID));
                rs2 = pstmt.executeQuery();
                if (rs2.next()) {
                    exhibitionHalls.add(mapHall(rs2));
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
