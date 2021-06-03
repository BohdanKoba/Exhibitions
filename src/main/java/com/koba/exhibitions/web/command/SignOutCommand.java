package com.koba.exhibitions.web.command;

import com.koba.exhibitions.db.dao.util.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignOutCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws DBException {
        request.getSession().invalidate();
        return "index.jsp";
    }

}
