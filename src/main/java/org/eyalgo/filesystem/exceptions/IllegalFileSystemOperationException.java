package org.eyalgo.filesystem.exceptions;

public class IllegalFileSystemOperationException extends RuntimeException {
    private static final long serialVersionUID = 3494299262282486549L;

    public IllegalFileSystemOperationException() {
    }

    public IllegalFileSystemOperationException(String message) {
	super(message);
    }

    public IllegalFileSystemOperationException(Throwable cause) {
	super(cause);
    }

    public IllegalFileSystemOperationException(String message, Throwable cause) {
	super(message, cause);
    }

    public IllegalFileSystemOperationException(String message, Throwable cause, boolean enableSuppression,
	    boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

}
