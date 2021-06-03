package com.koba.exhibitions.web.command;

import com.koba.exhibitions.db.bean.Exhibition;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.koba.exhibitions.web.service.SortService.sort;

public class SortExhibitionsCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String sortMethod = request.getParameter("sortBy");
        List<Exhibition> exhibitions = (List<Exhibition>)session.getAttribute("exhibitions");
        exhibitions = sort(exhibitions, sortMethod);
        session.setAttribute("exhibitionsList", exhibitions);
        return "exhibitions.jsp";
    }

}
