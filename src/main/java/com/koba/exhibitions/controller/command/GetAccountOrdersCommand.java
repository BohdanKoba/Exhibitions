package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.bean.Account;
import com.koba.exhibitions.controller.service.AccountOrdersService;
import com.koba.exhibitions.dao.exception.DBException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetAccountOrdersCommand implements Command{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws DBException, ServletException, IOException {
        String referer = request.getHeader("Referer");
        int accountId = ((Account) request.getAttribute("account")).getId();
        AccountOrdersService service = new AccountOrdersService();
        service.getAccountOrders(accountId);
        request.getRequestDispatcher(referer).forward(request, response);
    }

}
