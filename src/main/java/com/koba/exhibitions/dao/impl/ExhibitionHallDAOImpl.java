//package com.koba.exhibitions.dao.impl;
//
//import com.koba.exhibitions.bean.Hall;
//import com.koba.exhibitions.dao.ExhibitionHallDAO;
//import com.koba.exhibitions.dao.connection.ConnectionPool;
//import com.koba.exhibitions.dao.exception.DBException;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import static com.koba.exhibitions.dao.connection.ConnectionPool.close;
//import static com.koba.exhibitions.dao.constant.Fields.*;
//import static com.koba.exhibitions.dao.constant.SQLQueries.GET_EXHIBITION_HALLS_ID;
//
//public class ExhibitionHallDAOImpl implements ExhibitionHallDAO {
//    private static final Logger logger = LogManager.getLogger(ExhibitionHallDAOImpl.class);
//
//    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
//
//    @Override
//    public List<Hall> getExhibitionHalls(Integer exhibitionId) throws DBException {
//        List<Hall> hallsId;
//
//        Connection con = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//
//        try {
//            con = connectionPool.getConnection();
//            stmt = con.createStatement();
//            rs = stmt.executeQuery(GET_EXHIBITION_HALLS_ID);
//            hallsId = mapHallsIdList(rs);
//            logger.info("List of exhibition halls has been successfully obtained");
//        } catch (SQLException ex) {
//            logger.error("Severe problem with database occurred", ex);
//            throw new DBException("Could not obtain a list", ex);
//        } finally {
//            close(con, stmt, rs);
//        }
//        return hallsId;
//    }
//
//    private List<Hall> mapHallsIdList(ResultSet rs) throws SQLException {
//        List<Hall> exhibitionHalls = new ArrayList<>();
//        while (rs.next()) {
//            Hall hall = mapHall(rs.getInt(EXHIBITION_HALL_COLUMN_EXHIBITION_ID));
//            exhibitionHalls.add(hall);
//        }
//        return exhibitionHalls;
//    }
//
//}
