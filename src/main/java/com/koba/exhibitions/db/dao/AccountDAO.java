package com.koba.exhibitions.db.dao;

import com.koba.exhibitions.db.dao.util.DBException;
import com.koba.exhibitions.db.bean.Account;
import com.koba.exhibitions.db.bean.RegistrationData;

public interface AccountDAO {
    /**
     * Registers new user account.
     *
     * @param data <code>RegistrationData</code> object which contains data need to create new account
     * @throws DBException if severe problem with database occurred
     */
    void registerAccount(RegistrationData data) throws DBException;

    /**
     * Returns <code>Account</code> object from database by login and password.
     *
     * @param login    account login
     * @param password account password
     * @return <code>Account</code> object if an account with such login and password exists in the database
     * @throws DBException if severe problem with database occurred
     */
    Account authorizeAccount(String login, String password) throws DBException;

    /**
     * Returns <code>Account</code> object from database by login.
     *
     * @param login account login
     * @return <code>Account</code> object if account with such login exists in the database
     * @throws DBException if severe problem with database occurred
     */
    Account getAccountByLogin(String login) throws DBException;

    /**
     * Updates user account info.
     *
     * @param account an account which needs to be updated
     * @throws DBException if severe problem with database occurred
     */
    void updateAccountInfo(Account account) throws DBException;

    /**
     * Deletes account from database.
     *
     * @param account an account which needs to be deleted
     * @throws DBException if severe problem with database occurred
     */
    void deleteAccount(Account account) throws DBException;

}

