package com.koba.exhibitions.controller.service;

import com.koba.exhibitions.bean.Account;
import com.koba.exhibitions.bean.RegistrationData;
import com.koba.exhibitions.controller.dependency_injection.Component;
import com.koba.exhibitions.controller.dependency_injection.Context;
import com.koba.exhibitions.dao.AccountDAO;
import com.koba.exhibitions.dao.exception.AuthorizationException;
import com.koba.exhibitions.dao.exception.DBException;
import com.koba.exhibitions.dao.exception.LoginExistsException;
import com.koba.exhibitions.dao.mysql_impl.AccountDAOImpl;

@Component
public class AccountService {
    private final AccountDAO accountDAO = Context.getObject(AccountDAOImpl.class);

    public Account authorizeAccount(String login, String password) throws DBException, AuthorizationException {
        return accountDAO.authorizeAccount(login, password);
    }

    public void registerAccount(RegistrationData data) throws DBException, LoginExistsException {
        accountDAO.registerAccount(data);
    }

}
