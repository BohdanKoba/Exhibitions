package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.bean.Account;
import com.koba.exhibitions.bean.Order;
import com.koba.exhibitions.controller.service.OrderService;
import com.koba.exhibitions.dao.exception.DBException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GetAccountOrdersCommand implements Command{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws DBException, ServletException, IOException {
//        String referer = request.getHeader("Referer");
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        OrderService service = new OrderService();
        List<Order> orders = service.getOrders(account.getId());
        request.setAttribute("orders", orders);
//        response.sendRedirect(referer);
        request.getRequestDispatcher("view/home.jsp").forward(request, response);
        // TODO check if works + refactor
    }

}
