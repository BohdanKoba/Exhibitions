package com.koba.exhibitions.controller.listener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class AppHttpSessionListener implements HttpSessionListener {
    private static final Logger logger = LogManager.getLogger(AppHttpSessionListener.class);

    public void sessionCreated(HttpSessionEvent event) {
        logger.info("Session " + event.getSession().getId() + " created");
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        logger.info("Session " + event.getSession().getId() + " destroyed");
    }

}
