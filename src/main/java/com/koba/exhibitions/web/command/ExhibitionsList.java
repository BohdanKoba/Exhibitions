package com.koba.exhibitions.web.command;

import com.koba.exhibitions.db.bean.Account;
import com.koba.exhibitions.db.bean.Exhibition;
import com.koba.exhibitions.db.dao.impl.ExhibitionDAOImpl;
import com.koba.exhibitions.db.dao.util.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.koba.exhibitions.web.Service.getExhibitions;

public class ExhibitionsList implements Command {
    private ExhibitionDAOImpl exhibitionDAO = new ExhibitionDAOImpl();

    @Override

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        getExhibitions(session);
        return "main.jsp";
    }

}
