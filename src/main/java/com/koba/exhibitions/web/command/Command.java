package com.koba.exhibitions.web.command;

import com.koba.exhibitions.db.dao.util.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    String execute(HttpServletRequest request, HttpServletResponse response) throws DBException;
}
