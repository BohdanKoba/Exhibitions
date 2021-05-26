package com.koba.exhibitions.db.dao.interfaces;

import com.koba.exhibitions.db.dao.DBException;
import com.koba.exhibitions.db.entity.Category;

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
