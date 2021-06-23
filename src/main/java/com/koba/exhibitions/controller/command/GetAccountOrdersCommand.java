package com.koba.exhibitions.controller.command;

import com.koba.exhibitions.bean.Account;
import com.koba.exhibitions.bean.Order;
import com.koba.exhibitions.controller.dependency_injection.Context;
import com.koba.exhibitions.controller.service.OrderService;
import com.koba.exhibitions.dao.exception.DBException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GetAccountOrdersCommand implements Command{
    private final OrderService orderService = Context.getObject(OrderService.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws DBException, ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");

        List<Order> orders = orderService.getOrders(account.getId());
        request.getSession().setAttribute("orders", orders);
        response.sendRedirect("view/home.jsp");
    }

}
