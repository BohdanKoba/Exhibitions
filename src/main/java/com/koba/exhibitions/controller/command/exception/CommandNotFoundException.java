package com.koba.exhibitions.controller.command.exception;

public class CommandNotFoundException extends Exception {
    private static final long serialVersionUID = 7188035217042791478L;

    public CommandNotFoundException(String message) {
        super(message);
    }
}
