package org.eyalgo.filesystem.exceptions;

public class PathNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -4186864932736545835L;

    public PathNotFoundException() {
    }

    public PathNotFoundException(String message) {
	super(message);
    }

    public PathNotFoundException(Throwable cause) {
	super(cause);
    }

    public PathNotFoundException(String message, Throwable cause) {
	super(message, cause);
    }

    public PathNotFoundException(String message, Throwable cause, boolean enableSuppression,
	    boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

}
