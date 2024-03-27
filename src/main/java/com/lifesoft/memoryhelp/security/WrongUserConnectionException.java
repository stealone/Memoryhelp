package com.lifesoft.memoryhelp.security;

import java.sql.SQLException;

public class WrongUserConnectionException extends SQLException {

    /**
     * Creates a new instance of <code>WrongConnectionUserException</code>
     * without detail message.
     */
    public WrongUserConnectionException(){

    }

    /**
     * Constructs an instance of <code>WrongConnectionUserException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public WrongUserConnectionException(String msg) {
            super(msg);
    }

    /**
     *
     * @param msg
     * @param cause
     */
    public WrongUserConnectionException(String msg, Throwable cause) {
            super(msg, cause);
    }
}
