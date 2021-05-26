package com.koba.exhibitions.web.command;

import com.koba.exhibitions.db.dao.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

public interface Command extends Serializable {
    String execute(HttpServletRequest request, HttpServletResponse response) throws DBException;
}
