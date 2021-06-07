package com.koba.exhibitions.dao.exception;

public class DBException extends Exception {
    private static final long serialVersionUID = -8789383628342267067L;

    public DBException(String message) {
        super(message);
    }

    public DBException(String message, Throwable cause) {
        super(message, cause);
    }
}
