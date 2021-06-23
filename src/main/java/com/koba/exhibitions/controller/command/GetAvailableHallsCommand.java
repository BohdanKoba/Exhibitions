package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.bean.Hall;
import com.koba.exhibitions.controller.dependency_injection.Context;
import com.koba.exhibitions.controller.service.HallService;
import com.koba.exhibitions.dao.exception.DBException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetAvailableHallsCommand implements Command {
    private final HallService hallService = Context.getObject(HallService.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws DBException, ServletException, IOException {
        String dateFrom = request.getParameter("dateFrom");
        String dateTo = request.getParameter("dateTo");

        List<Hall> halls = hallService.getAvailableHalls(dateFrom, dateTo);
        for (Hall h: halls) {
            System.out.println(h.getHallName());
        }
        request.setAttribute("halls", halls);
        request.getRequestDispatcher("view/admin/addExhibition.jsp").forward(request, response);
    }

}
