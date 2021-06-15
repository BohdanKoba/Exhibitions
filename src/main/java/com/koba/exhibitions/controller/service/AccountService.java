package com.koba.exhibitions.controller.service;

import com.koba.exhibitions.bean.Account;
import com.koba.exhibitions.controller.dependencyInjection.Context;
import com.koba.exhibitions.dao.AccountDAO;
import com.koba.exhibitions.dao.exception.AuthorizationException;
import com.koba.exhibitions.dao.exception.DBException;
import com.koba.exhibitions.dao.impl.AccountDAOImpl;

public class AccountService {
    public Account authorizeAccount(String login, String password) throws DBException, AuthorizationException {
        AccountDAO accountDAO = Context.getObject(AccountDAOImpl.class);
        return accountDAO.authorizeAccount(login, password);
    }

}
