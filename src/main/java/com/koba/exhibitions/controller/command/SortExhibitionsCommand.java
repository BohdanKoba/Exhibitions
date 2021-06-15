package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.bean.Exhibition;
import com.koba.exhibitions.controller.service.SortService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class SortExhibitionsCommand implements Command{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String sortMethod = request.getParameter("sortBy");
        List<Exhibition> exhibitions = (List<Exhibition>)session.getAttribute("exhibitions");
        SortService service = new SortService();
        service.sort(exhibitions, sortMethod);
        request.setAttribute("exhibitions", exhibitions);
        request.getRequestDispatcher("view/exhibitions.jsp").forward(request, response);
    }

}
