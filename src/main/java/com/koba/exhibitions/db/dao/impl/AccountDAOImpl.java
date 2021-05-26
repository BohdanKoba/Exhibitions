package com.koba.exhibitions.db.dao.impl;

import static com.koba.exhibitions.db.dao.Fields.*;
import static com.koba.exhibitions.db.dao.connection.Connector.close;

import com.koba.exhibitions.db.dao.DBException;
import com.koba.exhibitions.db.dao.connection.Connector;
import com.koba.exhibitions.db.dao.interfaces.AccountDAO;
import com.koba.exhibitions.db.entity.Account;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AccountDAOImpl implements AccountDAO {
    private static final Logger logger = LogManager.getLogger(AccountDAOImpl.class);

    private static final String CREATE_ACCOUNT = "INSERT INTO account (login, password, first_name, last_name, email) VALUES (?, ?, ?, ?, ?)";
    private static final String GET_ACCOUNT_BY_LOGIN_AND_PASSWORD = "SELECT * FROM account WHERE login=? AND password=?";
    private static final String GET_ACCOUNT_BY_LOGIN = "SELECT * FROM account WHERE login=?";
    private static final String UPDATE_ACCOUNT_INFO = "UPDATE account SET password=?, first_name=?, last_name=?, email=? WHERE id=?";
    private static final String DELETE_ACCOUNT = "DELETE FROM account WHERE id=?";

    private final Connector connector = Connector.getInstance();

    @Override
    public void registerAccount(Account account) throws DBException {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = connector.getConnection();
            pstmt = con.prepareStatement(CREATE_ACCOUNT);
            int k = 1;
            pstmt.setString(k++, account.getLogin());
            pstmt.setString(k++, account.getPassword());
            pstmt.setString(k++, account.getFirstName());
            pstmt.setString(k++, account.getLastName());
            pstmt.setString(k++, account.getEmail());
            pstmt.executeUpdate();
            logger.info("New account has been successfully created");
        } catch (SQLException ex) {
            logger.error("Error occurred! Could not create new account", ex);
            throw new DBException("Could not create new account", ex);
        } finally {
            close(con, pstmt);
        }
    }

    @Override
    public Account authorizeAccount(String login, String password) throws DBException {
        Account account;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = connector.getConnection();
            pstmt = con.prepareStatement(GET_ACCOUNT_BY_LOGIN_AND_PASSWORD);
            int k = 1;
            pstmt.setString(k++, login);
            pstmt.setString(k++, password);
            pstmt.executeQuery();
            account = mapAccount(rs);
            logger.info("Account has been successfully authorized");
        } catch (SQLException ex) {
            logger.error("Error occurred! Could not authorize an account", ex);
            throw new DBException("Could not authorize an account", ex);
        } finally {
            close(con, pstmt, rs);
        }
        return account;
    }

    @Override
    public Account getAccountByLogin(String login) throws DBException {
        Account account;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = connector.getConnection();
            pstmt = con.prepareStatement(GET_ACCOUNT_BY_LOGIN);
            pstmt.setString(1, login);
            rs = pstmt.executeQuery();
            account = mapAccount(rs);
            logger.info("Account has been successfully obtained");
        } catch (SQLException ex) {
            logger.error("Error occurred! Could not get account", ex);
            throw new DBException("Could not get account", ex);
        } finally {
            close(con, pstmt, rs);
        }
        return account;
    }

    @Override
    public void updateAccountInfo(Account account) throws DBException {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = connector.getConnection();
            pstmt = con.prepareStatement(UPDATE_ACCOUNT_INFO);
            int k = 1;
            pstmt.setString(k++, account.getLogin());
            pstmt.setString(k++, account.getPassword());
            pstmt.setString(k++, account.getFirstName());
            pstmt.setString(k++, account.getLastName());
            pstmt.setString(k++, account.getEmail());
            pstmt.setInt(k++, account.getId());
            pstmt.executeUpdate();
            logger.info("Account info has been successfully updated");
        } catch (SQLException ex) {
            logger.error("Error occurred! Could not update account info", ex);
            throw new DBException("Could not update account info", ex);
        } finally {
            close(con, pstmt);
        }
    }

    @Override
    public void deleteAccount(Account account) throws DBException {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = connector.getConnection();
            pstmt = con.prepareStatement(DELETE_ACCOUNT);
            pstmt.setString(1, account.getLogin());
            pstmt.executeUpdate();
            logger.info("Account has been successfully deleted");
        } catch (SQLException ex) {
            logger.error("Error occurred! Could not delete account", ex);
            throw new DBException("Could not delete account", ex);
        } finally {
            close(con, pstmt);
        }
    }

    private Account mapAccount(ResultSet rs) throws SQLException {
        Account account = new Account();
        while (rs.next()) {
            account.setId(rs.getInt(COLUMN_ID));
            account.setLogin(rs.getString(ACCOUNT_COLUMN_LOGIN));
            account.setPassword(rs.getString(ACCOUNT_COLUMN_PASSWORD));
            account.setFirstName(rs.getString(ACCOUNT_COLUMN_FIRST_NAME));
            account.setLastName(rs.getString(ACCOUNT_COLUMN_LAST_NAME));
            account.setEmail(rs.getString(ACCOUNT_COLUMN_EMAIL));
            account.setRoleId(rs.getInt(ACCOUNT_COLUMN_ROLE_ID));
        }
        return account;
    }

}
