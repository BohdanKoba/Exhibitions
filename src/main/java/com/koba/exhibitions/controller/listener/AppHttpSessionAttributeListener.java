package com.koba.exhibitions.controller.listener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class AppHttpSessionAttributeListener implements HttpSessionAttributeListener {
//    private static final Logger logger = LogManager.getLogger(AppHttpSessionAttributeListener.class);

    public void attributeAdded(HttpSessionBindingEvent event) {
//        logger.info("Attribute " + event.getName() + " added to the HttpSession object");
    }

    public void attributeRemoved(HttpSessionBindingEvent event) {
//        logger.info("Attribute " + event.getName() + " removed from the HttpSession object");
    }

    public void attributeReplaced(HttpSessionBindingEvent event) {
//        logger.info("Attribute " + event.getName() + " replaced in the HttpSession object");
    }

}
