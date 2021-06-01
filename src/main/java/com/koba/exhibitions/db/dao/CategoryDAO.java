package com.koba.exhibitions.db.dao;

import com.koba.exhibitions.db.dao.util.DBException;
import com.koba.exhibitions.db.bean.Category;

import java.util.List;

public interface CategoryDAO {
    /**
     * Returns all exhibition categories
     *
     * @return list of <code>Category</code> objects
     * @throws DBException if severe problem with database occurred
     */
    List<Category> getAllCategories() throws DBException;

}
