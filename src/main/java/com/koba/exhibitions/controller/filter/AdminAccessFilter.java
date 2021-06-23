package com.koba.exhibitions.controller.filter;

import com.koba.exhibitions.bean.Account;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminAccessFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Account account = (Account) request.getSession().getAttribute("account");
        if (account == null || !account.getRole().equals("admin")) {
            response.sendRedirect(request.getContextPath() + "/view/error/accessDenied.jsp");
        } else {
            filterChain.doFilter(request, response);
        }
    }

}
