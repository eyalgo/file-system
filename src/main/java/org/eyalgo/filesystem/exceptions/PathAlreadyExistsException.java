package org.eyalgo.filesystem.exceptions;

public class PathAlreadyExistsException extends RuntimeException {
    private static final long serialVersionUID = -4186864932736545835L;

    public PathAlreadyExistsException() {
    }

    public PathAlreadyExistsException(String message) {
	super(message);
    }

    public PathAlreadyExistsException(Throwable cause) {
	super(cause);
    }

    public PathAlreadyExistsException(String message, Throwable cause) {
	super(message, cause);
    }

    public PathAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
	    boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

}
