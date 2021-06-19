package com.koba.exhibitions.dao.impl;

import com.koba.exhibitions.bean.Exhibition;
import com.koba.exhibitions.bean.ExhibitionData;
import com.koba.exhibitions.controller.dependencyInjection.Component;
import com.koba.exhibitions.dao.ExhibitionDAO;
import com.koba.exhibitions.dao.exception.DBException;
import com.koba.exhibitions.dao.connection.ConnectionPool;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.koba.exhibitions.dao.connection.ConnectionPool.close;
import static com.koba.exhibitions.dao.constant.SQLQueries.*;
import static com.koba.exhibitions.dao.constant.Fields.*;

@Component
public class ExhibitionDAOImpl implements ExhibitionDAO {
    private static final Logger logger = LogManager.getLogger(ExhibitionDAOImpl.class);

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void createExhibition(ExhibitionData data) throws DBException {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = connectionPool.getConnection();
            pstmt = con.prepareStatement(CREATE_EXHIBITION);
            int k = 1;
            pstmt.setString(k++, data.getTitle());
            pstmt.setString(k++, data.getDescription());
            pstmt.setString(k++, data.getPrice());
            pstmt.setObject(k++, data.getStartDate());
            pstmt.setObject(k++, data.getEndDate());
            pstmt.setObject(k++, data.getOpeningTime());
            pstmt.setObject(k++, data.getClosingTime());

            pstmt.executeUpdate();
            logger.info("New exhibition has been successfully created");
        } catch (SQLException ex) {
            throw new DBException("Could not create new exhibition", ex);
        } finally {
            close(con, pstmt);
        }
    }

    @Override
    public Exhibition getExhibition(Integer id) throws DBException {
        Exhibition exhibition;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = connectionPool.getConnection();
            pstmt = con.prepareStatement(GET_EXHIBITION_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (!rs.next()) {
                throw new SQLException();
            }
            exhibition = mapExhibition(rs);
            logger.info("Exhibition has been successfully obtained");
        } catch (SQLException ex) {
            throw new DBException("Could not get exhibition", ex);
        } finally {
            close(con, pstmt, rs);
        }
        return exhibition;
    }

    @Override
    public List<Exhibition> getAllExhibitions() throws DBException {
        return getExhibitions(GET_ALL_EXHIBITIONS);
    }

    @Override
    public List<Exhibition> getAvailableExhibitions() throws DBException {
        return getExhibitions(GET_AVAILABLE_EXHIBITIONS);
    }

    @Override
    public void updateExhibitionStatus(Integer id, String status) throws DBException {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = connectionPool.getConnection();
            pstmt = con.prepareStatement(UPDATE_EXHIBITION_STATUS);
            int k = 1;
            pstmt.setString(k++, status);
            pstmt.setInt(k++, id);
            pstmt.executeUpdate();
            logger.info("Exhibition status has been successfully updated");
        } catch (SQLException ex) {
            throw new DBException("Could not update account status", ex);
        } finally {
            close(con, pstmt);
        }
    }

    private Exhibition mapExhibition(ResultSet rs) throws SQLException {
        Exhibition exhibition = new Exhibition();

        exhibition.setId(rs.getInt(COLUMN_ID));
        exhibition.setTitle(rs.getString(EXHIBITION_COLUMN_TITLE));
        exhibition.setDescription(rs.getString(EXHIBITION_COLUMN_DESCRIPTION));
        exhibition.setPrice(rs.getInt(EXHIBITION_COLUMN_PRICE));
        exhibition.setStartDate(rs.getString(EXHIBITION_COLUMN_START_DATE));
        exhibition.setEndDate(rs.getString(EXHIBITION_COLUMN_END_DATE));
        exhibition.setOpeningTime(rs.getTime(EXHIBITION_COLUMN_OPENING_TIME).toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm")));
        exhibition.setClosingTime(rs.getTime(EXHIBITION_COLUMN_CLOSING_TIME).toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm")));
        exhibition.setStatus(rs.getString(EXHIBITION_COLUMN_STATUS));
        exhibition.setTicketsSold(rs.getInt(EXHIBITION_COLUMN_TICKETS_SOLD));

        return exhibition;
    }

    private List<Exhibition> getExhibitions(String query) throws DBException {
        List<Exhibition> exhibitions;

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = connectionPool.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            exhibitions = mapExhibitionsList(rs);
            logger.info("List of exhibitions has been successfully obtained");
        } catch (SQLException ex) {
            throw new DBException("Could not obtain a list", ex);
        } finally {
            close(con, stmt, rs);
        }
        return exhibitions;
    }

    private List<Exhibition> mapExhibitionsList(ResultSet rs) throws SQLException {
        List<Exhibition> exhibitions = new ArrayList<>();
        while (rs.next()) {
            Exhibition exhibition = mapExhibition(rs);
            exhibitions.add(exhibition);
        }
        return exhibitions;
    }

}
