package com.koba.exhibitions.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetLanguageCommand implements Command{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String referer = request.getHeader("Referer");
        String language = request.getParameter("language");
        request.getSession().setAttribute("language", language);
        response.sendRedirect(referer);
    }

}
