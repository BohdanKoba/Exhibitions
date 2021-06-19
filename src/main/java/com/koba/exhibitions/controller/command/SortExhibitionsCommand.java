package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.bean.Exhibition;
import com.koba.exhibitions.controller.service.SortService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SortExhibitionsCommand implements Command{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Exhibition> exhibitions = (List<Exhibition>)request.getSession().getAttribute("exhibitions");
        String sortMethod = request.getParameter("sortBy");

        SortService sortService = new SortService();
        sortService.sort(exhibitions, sortMethod);
        request.setAttribute("exhibitions", exhibitions);
        request.getRequestDispatcher("view/exhibitions.jsp").forward(request, response);
    }

}
