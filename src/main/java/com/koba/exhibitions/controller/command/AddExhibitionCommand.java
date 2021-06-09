package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.dao.exception.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddExhibitionCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws DBException {
        System.out.println(request.getParameter("title"));
        System.out.println(request.getParameter("description"));
        System.out.println(request.getParameter("price"));
        System.out.println(request.getParameter("dateFrom"));
        System.out.println(request.getParameter("dateTo"));
        System.out.println(request.getParameter("timeFrom"));
        System.out.println(request.getParameter("timeTo"));
        return "view/admin/addExhibition.jsp";
    }

}
