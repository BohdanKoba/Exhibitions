package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.bean.Account;
import com.koba.exhibitions.dao.exception.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoToCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws DBException {
        Account account = (Account) request.getSession().getAttribute("account");
        String address = request.getParameter("address");
        if (account == null && (address.equals("view/buyTickets.jsp") || address.equals("view/home.jsp"))) {
            return "view/signIn.jsp";
        }
        return address;
    }

}
