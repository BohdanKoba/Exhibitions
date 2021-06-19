package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.bean.Exhibition;
import com.koba.exhibitions.dao.exception.DBException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class FilterExhibitionsCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws DBException, ServletException, IOException {
        List<Exhibition> exhibitions = (List<Exhibition>) request.getSession().getAttribute("exhibitions");
        LocalDate dateFrom = LocalDate.parse(request.getParameter("dateFrom"));
        LocalDate dateTo = LocalDate.parse(request.getParameter("dateTo"));

        List<Exhibition> filteredExhibitions = exhibitions.stream()
                .filter(e -> ((LocalDate.parse(e.getStartDate()).compareTo(dateFrom) >= 0 &&
                        LocalDate.parse(e.getEndDate()).compareTo(dateTo) <= 0)) ||
                        ((LocalDate.parse(e.getStartDate()).compareTo(dateFrom) <= 0 &&
                        LocalDate.parse(e.getEndDate()).compareTo(dateFrom) <= 0))).collect(Collectors.toList());

        for (Exhibition e: filteredExhibitions) {
            System.out.println(e.getTitle());
            System.out.println(e.getStartDate() + " - " + e.getEndDate());
        }
        request.setAttribute("exhibitions", filteredExhibitions);
        request.getRequestDispatcher("view/exhibitions.jsp").forward(request, response);
    }

}
