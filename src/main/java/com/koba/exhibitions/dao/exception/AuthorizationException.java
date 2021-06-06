package com.koba.exhibitions.dao.exception;

public class AuthorizationException extends Exception {
    private static final long serialVersionUID = 4476200202587853995L;

    public AuthorizationException(String message) {
        super(message);
    }
}
