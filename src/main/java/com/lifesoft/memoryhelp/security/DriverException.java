package com.lifesoft.memoryhelp.security;

public class DriverException extends ClassNotFoundException{
    /**
     * Creates a new instance of <code>DriverException</code> without detail
     * message.
     */
    public DriverException() {
    }

    /**
     * Constructs an instance of <code>DriverException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public DriverException(String msg) {
        super(msg);
    }

    public DriverException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
