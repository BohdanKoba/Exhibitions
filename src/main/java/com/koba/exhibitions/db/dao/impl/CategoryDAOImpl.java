package com.koba.exhibitions.db.dao.impl;

import static com.koba.exhibitions.db.dao.Fields.CATEGORY_COLUMN_CATEGORY_NAME;
import static com.koba.exhibitions.db.dao.Fields.COLUMN_ID;
import static com.koba.exhibitions.db.dao.connection.Connector.close;

import com.koba.exhibitions.db.dao.DBException;
import com.koba.exhibitions.db.dao.connection.Connector;
import com.koba.exhibitions.db.dao.interfaces.CategoryDAO;
import com.koba.exhibitions.db.entity.Category;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    private static final Logger logger = LogManager.getLogger(CategoryDAOImpl.class);

    private static final String GET_ALL_CATEGORIES = "SELECT * FROM cat ORDER BY id";

    private final Connector connector = Connector.getInstance();

    @Override
    public List<Category> getAllCategories() throws DBException {
        List<Category> categories;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = connector.getConnection();
            pstmt = con.prepareStatement(GET_ALL_CATEGORIES);
            rs = pstmt.executeQuery();
            categories = mapCategoryList(rs);
            logger.info("List of categories has been successfully obtained");
        } catch (SQLException ex) {
            logger.error("Error occurred! Could not obtain a list", ex);
            throw new DBException("Could not obtain a list", ex);
        } finally {
            close(con, pstmt, rs);
        }
        return categories;
    }

    private List<Category> mapCategoryList(ResultSet rs) throws SQLException {
        List<Category> categories = new ArrayList<>();
        while (rs.next()) {
            Category category = new Category();
            category.setId(rs.getInt(COLUMN_ID));
            category.setCategoryName(rs.getString(CATEGORY_COLUMN_CATEGORY_NAME));
            categories.add(category);
        }
        return categories;
    }

}
