package com.koba.exhibitions.web.command;

import com.koba.exhibitions.db.dao.util.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.koba.exhibitions.web.service.ExhibitionService.getExhibitions;

public class ExhibitionsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws DBException {
        HttpSession session = request.getSession();
        getExhibitions(session);
        return "exhibitions.jsp";
    }

}
