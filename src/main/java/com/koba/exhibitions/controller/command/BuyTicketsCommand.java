package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.dao.exception.DBException;
import com.koba.exhibitions.dao.factory.DAOFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BuyTicketsCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws DBException, IOException {
        int id = Integer.parseInt(request.getParameter("exhibitionId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int bill = Integer.parseInt(request.getParameter("bill"));


        DAOFactory factory = DAOFactory.getInstance();


        response.sendRedirect("view/buyTickets.jsp");


//        HttpSession session = request.getSession();
//        System.out.println(request.getParameter("qty") + " : " + request.getParameter("exhibition"));
////        String s = session.getAttribute()
//        String ex = request.getParameter("exhibitionTitle");
//        String q = request.getParameter("quantity");
//        System.out.println(q + " : " + ex);


//        List<Exhibition> exhibitions = (List<Exhibition>)session.getAttribute("exhibitions");
//        List list = new ArrayList();
//        Map map = request.getParameterMap();
//        for (Object key: map.keySet())
//        {
//            String keyStr = (String)key;
//            String[] value = (String[])map.get(keyStr);
//            System.out.println("Key " + key + "   :   " + Arrays.toString(value));
//        }
//        for (Map.Entry<String, String[]> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.toString());
//        }
//        for (Map.Entry<String, Object> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
//        }


//        Account account = (Account) session.getAttribute("account");
//        if (account == null) {
//            return "signIn.jsp";
//        } else {
//            int id = Integer.parseInt(request.getParameter("exhibitionId"));
//            DAOFactory factory = DAOFactory.getInstance();
//            ExhibitionDAO exhibitionDAO = factory.getExhibitionDAO();
//            Exhibition exhibition = exhibitionDAO.getExhibition(id);
//            if (exhibition.getStatus().equals("canceled")) {
//                session.removeAttribute("exhibitions");
//                throw new DBException("Can't buy tickets. Exhibition cancelled.");
//            }
//        }
    }

}
