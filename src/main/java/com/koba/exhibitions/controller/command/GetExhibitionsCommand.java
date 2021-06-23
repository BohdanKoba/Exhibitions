package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.bean.Account;
import com.koba.exhibitions.bean.Exhibition;
import com.koba.exhibitions.controller.dependency_injection.Context;
import com.koba.exhibitions.controller.service.GetExhibitionsService;
import com.koba.exhibitions.dao.exception.DBException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

public class GetExhibitionsCommand implements Command {

    private final GetExhibitionsService getExhibitionsService = Context.getObject(GetExhibitionsService.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, DBException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");

        if (session.getAttribute("exhibitions") == null) {
            List<Exhibition> exhibitions = getExhibitionsService.getExhibitions(account);
            session.setAttribute("exhibitions", exhibitions);
        }
        request.getRequestDispatcher("view/exhibitions.jsp").forward(request, response);
    }

}
