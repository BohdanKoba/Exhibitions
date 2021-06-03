package com.koba.exhibitions.web.command;

import com.koba.exhibitions.db.bean.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddToCartCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String referer = request.getHeader("Referer");
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        if (account == null) {
            return "signIn.jsp";
        } else {
            //TODO add to card impl !!!!!!!!!!!!!
        }
        return referer;
    }

}
