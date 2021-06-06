package com.koba.exhibitions.dao.exception;

public class LoginExistsException extends Exception {
    private static final long serialVersionUID = -3976112145037827273L;

    public LoginExistsException(String message) {
        super(message);
    }
}
