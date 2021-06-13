package com.koba.exhibitions.dao.factory;

import com.koba.exhibitions.dao.*;
import com.koba.exhibitions.dao.impl.*;

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
    public ExhibitionDAO getExhibitionDAO() {
        return new ExhibitionDAOImpl();
    }

//    @Override
//    public ExhibitionHallDAO getExhibitionHallDAO() {
//        return new ExhibitionHallDAOImpl();
//    }

    @Override
    public HallDAO getHallDAO() {
        return new HallDAOImpl();
    }

    @Override
    public OrderDAO getOrderDAO() {
        return new OrderDAOImpl();
    }

//    @Override
//    public <T extends DAO> T getInstance(Class<T> clazz) {
//        return getDAO(clazz);
//    }
//
//    public <T extends DAO> T getDAO(Class<AccountDAO> clazz) {
//        return new AccountDAOImpl();
//    }
}
