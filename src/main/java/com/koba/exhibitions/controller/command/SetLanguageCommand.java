package com.koba.exhibitions.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetLanguageCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String referer = request.getHeader("Referer");
        String language = request.getParameter("language");
        request.getSession().setAttribute("language", language);
        return referer;
    }

}
