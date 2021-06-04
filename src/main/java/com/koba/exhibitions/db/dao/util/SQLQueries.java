package com.koba.exhibitions.db.dao.util;

/**
 * Class that contains MySQL queries.
 */
public class SQLQueries {
    public static final String CREATE_ACCOUNT = "INSERT INTO account (login, password, first_name, last_name, email) " +
            "VALUES (?, ?, ?, ?, ?)";
    public static final String GET_ACCOUNT_BY_LOGIN_AND_PASSWORD = "SELECT * FROM account WHERE login=? AND password=?";
    public static final String GET_ACCOUNT_BY_LOGIN = "SELECT * FROM account WHERE login=?";
    public static final String UPDATE_ACCOUNT_INFO = "UPDATE account SET password=?, first_name=?, last_name=?, email=? " +
            "WHERE id=?";
    public static final String DELETE_ACCOUNT = "DELETE FROM account WHERE id=?";

    public static final String CREATE_EXHIBITION = "INSERT INTO exhibition (title, description, price, start_date, " +
            "end_date, opening_time, closing_time) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String GET_EXHIBITION_BY_ID = "SELECT * FROM exhibition WHERE id=?";
    public static final String GET_ALL_EXHIBITIONS = "SELECT * FROM exhibition ORDER BY title";
    public static final String GET_AVAILABLE_EXHIBITIONS = "SELECT * FROM exhibition WHERE status='active' " +
            "AND end_date > CURDATE() ORDER BY title";
    public static final String UPDATE_EXHIBITION_STATUS = "UPDATE exhibition SET status=? WHERE id=?";

}
