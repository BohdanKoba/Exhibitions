package com.koba.exhibitions.dao.impl;

import static com.koba.exhibitions.dao.connection.ConnectionPool.close;
import static com.koba.exhibitions.dao.constant.Fields.*;
import static com.koba.exhibitions.dao.constant.SQLQueries.*;

import com.koba.exhibitions.controller.dependencyInjection.Component;
import com.koba.exhibitions.dao.AccountDAO;
import com.koba.exhibitions.dao.exception.AuthorizationException;
import com.koba.exhibitions.dao.exception.DBException;
import com.koba.exhibitions.dao.connection.ConnectionPool;
import com.koba.exhibitions.bean.Account;
import com.koba.exhibitions.bean.RegistrationData;
import com.koba.exhibitions.dao.exception.LoginExistsException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AccountDAOImpl implements AccountDAO {
    private static final Logger logger = LogManager.getLogger(AccountDAOImpl.class);

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void registerAccount(RegistrationData data) throws DBException, LoginExistsException {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = connectionPool.getConnection();
            pstmt = con.prepareStatement(CREATE_ACCOUNT);
            int k = 1;
            pstmt.setString(k++, data.getLogin());
            pstmt.setString(k++, data.getPassword());
            pstmt.setString(k++, data.getFirstName());
            pstmt.setString(k++, data.getLastName());
            pstmt.setString(k++, data.getEmail());
            try {
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                throw new LoginExistsException("Account with such login is already exists");
            }
            logger.info("New account has been successfully created");
        } catch (SQLException ex) {
            logger.error("Severe problem with database occurred", ex);
            throw new DBException("Could not create new account", ex);
        } finally {
            close(con, pstmt);
        }
    }

    @Override
    public Account authorizeAccount(String login, String password) throws DBException, AuthorizationException {
        Account account;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = connectionPool.getConnection();
            pstmt = con.prepareStatement(GET_ACCOUNT_BY_LOGIN_AND_PASSWORD);
            int k = 1;
            pstmt.setString(k++, login);
            pstmt.setString(k++, password);
            rs = pstmt.executeQuery();
            if (!rs.next()) {
                throw new AuthorizationException("Wrong login or password");
            }
            account = mapAccount(rs);
            logger.info("Account has been successfully authorized");
        } catch (SQLException ex) {
            logger.error("Severe problem with database occurred", ex);
            throw new DBException("Could not authorize account", ex);
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
            con = connectionPool.getConnection();
            pstmt = con.prepareStatement(GET_ACCOUNT_BY_LOGIN);
            pstmt.setString(1, login);
            rs = pstmt.executeQuery();
            if (!rs.next()) {
                throw new SQLException();
            }
            account = mapAccount(rs);
            logger.info("Account has been successfully obtained");
        } catch (SQLException ex) {
            logger.error("Severe problem with database occurred", ex);
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
            con = connectionPool.getConnection();
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
            logger.error("Severe problem with database occurred", ex);
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
            con = connectionPool.getConnection();
            pstmt = con.prepareStatement(DELETE_ACCOUNT);
            pstmt.setString(1, account.getLogin());
            pstmt.executeUpdate();
            logger.info("Account has been successfully deleted");
        } catch (SQLException ex) {
            logger.error("Severe problem with database occurred", ex);
            throw new DBException("Could not delete account", ex);
        } finally {
            close(con, pstmt);
        }
    }

    private Account mapAccount(ResultSet rs) throws SQLException {
        Account account = new Account();

        account.setId(rs.getInt(COLUMN_ID));
        account.setLogin(rs.getString(ACCOUNT_COLUMN_LOGIN));
        account.setPassword(rs.getString(ACCOUNT_COLUMN_PASSWORD));
        account.setFirstName(rs.getString(ACCOUNT_COLUMN_FIRST_NAME));
        account.setLastName(rs.getString(ACCOUNT_COLUMN_LAST_NAME));
        account.setEmail(rs.getString(ACCOUNT_COLUMN_EMAIL));
        account.setRole(rs.getString(ACCOUNT_COLUMN_ROLE));

        return account;
    }

}
