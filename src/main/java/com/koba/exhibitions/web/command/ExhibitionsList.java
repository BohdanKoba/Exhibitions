package com.koba.exhibitions.web.command;

import com.koba.exhibitions.db.bean.Exhibition;
import com.koba.exhibitions.db.dao.impl.ExhibitionDAOImpl;
import com.koba.exhibitions.db.dao.util.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ExhibitionsList implements Command {
    private ExhibitionDAOImpl exhibitionDAO = new ExhibitionDAOImpl();

    @Override

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String referer = request.getHeader("Referer");
        List<Exhibition> exhibitions = null;
        try {
            exhibitions = exhibitionDAO.getAvailableExhibitions();
        } catch (DBException e) {
            System.out.println("ERRRRRRRRRRRRRRROR");
            e.printStackTrace(); //TODO do something
        }
//            filter(catalog, filterMethod, filter);
//            sort(catalog, sortMethod);
        request.setAttribute("exhibitionsList", exhibitions);
//        public List<Exhibition> getExhibitions(String sortMethod, String filterMethod, String filter) {
//            List<Account> catalog = catalogDao.getClientTable();
//            filter(catalog, filterMethod, filter);
//            sort(catalog, sortMethod);
//            return catalog;
//        }
        return referer;
    }
}
