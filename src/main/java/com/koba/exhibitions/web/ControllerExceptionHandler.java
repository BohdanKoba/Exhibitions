//package com.koba.exhibitions.web;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class ControllerExceptionHandler extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Throwable throwable = (Throwable) req.getAttribute("javax.servlet.error.exception");
//
//        if (throwable != null) {
//            logger.warn("Occurred exception", throwable);
//        }
//        req.getRequestDispatcher("/WEB-INF/jsp/500.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
//    }
//
//}
