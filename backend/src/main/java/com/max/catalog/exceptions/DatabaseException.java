package com.max.catalog.exceptions;

public class DatabaseException extends RuntimeException {
    public DatabaseException (String msg) {
        super(msg);
    }
}
