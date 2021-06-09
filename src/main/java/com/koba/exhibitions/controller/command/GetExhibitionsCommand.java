package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.dao.exception.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.koba.exhibitions.controller.service.ExhibitionService.getExhibitions;

public class GetExhibitionsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws DBException {
        String referer = request.getHeader("Referer");
        HttpSession session = request.getSession();
        getExhibitions(session);
        return referer;
    }

}
