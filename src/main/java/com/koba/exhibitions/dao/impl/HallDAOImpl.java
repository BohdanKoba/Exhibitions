package com.koba.exhibitions.dao.impl;

import com.koba.exhibitions.bean.Hall;
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
            logger.error("Severe problem with database occurred", ex);
            throw new DBException("Could not obtain a list", ex);
        } finally {
            close(con, stmt, rs);
        }
        return halls;
    }

    @Override
    public List<Hall> getExhibitionHalls(Integer exhibitionId) throws DBException {
        List<Hall> exhibitionHalls;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = connectionPool.getConnection();
            pstmt = con.prepareStatement(GET_EXHIBITION_HALLS_ID);
            pstmt.setInt(1, exhibitionId);
            rs = pstmt.executeQuery();
            if (!rs.next()) {
                throw new SQLException();
            }
            exhibitionHalls = mapExhibitonHallsList(rs);
            logger.info("List of exhibition halls has been successfully obtained");
        } catch (SQLException ex) {
            logger.error("Severe problem with database occurred", ex);
            throw new DBException("Could not obtain a list", ex);
        } finally {
            close(con, pstmt, rs);
        }
        return exhibitionHalls;
    }

    private List<Hall> mapExhibitonHallsList(ResultSet rs) {
        List<Hall> exhibitionHalls = new ArrayList<>();

        while (rs.next()) {
            exhibitionHalls
            hallsIdList.add(rs.getInt(EXHIBITION_HALL_COLUMN_HALL_ID));
        }

        return exhibitionHalls;
    }

//    private List<Integer> mapHallsIdList(ResultSet rs) throws SQLException {
//        List<Integer> hallsIdList = new ArrayList<>();
//        while (rs.next()) {
//            hallsIdList.add(rs.getInt(EXHIBITION_HALL_COLUMN_HALL_ID));
//        }
//        return hallsIdList;
//    }

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
