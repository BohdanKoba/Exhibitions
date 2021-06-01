package com.koba.exhibitions.db.dao.factory;

import com.koba.exhibitions.db.dao.*;
import com.koba.exhibitions.db.dao.impl.*;

public class MySqlDAOFactory implements DAOFactory {
    private static MySqlDAOFactory instance;

    public static synchronized MySqlDAOFactory getInstance() {
        if (instance == null) {
            instance = new MySqlDAOFactory();
        }
        return instance;
    }

    private MySqlDAOFactory() {
    }

    @Override
    public AccountDAO getAccountDAO() {
        return new AccountDAOImpl();
    }

    @Override
    public CategoryDAO getCategoryDAO() {
        return new CategoryDAOImpl();
    }

    @Override
    public ExhibitionDAO getExhibitionDAO() {
        return new ExhibitionDAOImpl();
    }

    @Override
    public ExhibitionHallDAO getExhibitionHallDAO() {
        return new ExhibitionHallDAOImpl();
    }

    @Override
    public HallDAO getHallDAO() {
        return new HallDAOImpl();
    }

    @Override
    public OrderDAO getOrderDAO() {
        return new OrderDAOImpl();
    }

    @Override
    public OrderExhibitionDAO getOrderExhibitionDAO() {
        return new OrderExhibitionDAOImpl();
    }

}
