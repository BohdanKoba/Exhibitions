package com.koba.exhibitions.db.dao.factory;

import com.koba.exhibitions.db.dao.*;

public interface DAOFactory {

    static DAOFactory getInstance() {
        return MySqlDAOFactory.getInstance();
    }

    AccountDAO getAccountDAO();

    ExhibitionDAO getExhibitionDAO();

    ExhibitionHallDAO getExhibitionHallDAO();

    HallDAO getHallDAO();

    OrderDAO getOrderDAO();

    OrderExhibitionDAO getOrderExhibitionDAO();
}
