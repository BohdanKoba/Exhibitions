package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.dao.exception.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignOutCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws DBException {
        request.getSession().invalidate();
        return "view/index.jsp";
    }

}
