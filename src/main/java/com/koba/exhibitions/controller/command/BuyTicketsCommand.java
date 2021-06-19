package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.bean.OrderData;
import com.koba.exhibitions.controller.service.OrderService;
import com.koba.exhibitions.dao.exception.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BuyTicketsCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws DBException, IOException {
        int accountId = Integer.parseInt(request.getParameter("accountId"));
        int exhibitionId = Integer.parseInt(request.getParameter("exhibitionId"));
        short quantity = Short.parseShort(request.getParameter("quantity"));
        int bill = Integer.parseInt(request.getParameter("bill"));

        OrderData data = new OrderData(accountId, exhibitionId, quantity, bill);
        OrderService service = new OrderService();
        service.createOrder(data);
        response.sendRedirect("view/buyTickets.jsp");
    }

}
