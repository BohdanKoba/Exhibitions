package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.controller.service.ExhibitionService;
import com.koba.exhibitions.dao.exception.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeStatusCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws DBException, IOException {
        String referer = request.getHeader("Referer");
        int id = Integer.parseInt(request.getParameter("exhibitionId"));
        ExhibitionService service = new ExhibitionService();
        service.changeExhibitionStatus(id);
        request.getSession().removeAttribute("exhibitions");
        response.sendRedirect(referer);
    }

}
