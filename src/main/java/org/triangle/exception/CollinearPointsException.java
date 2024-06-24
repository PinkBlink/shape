package org.triangle.exception;

public class CollinearPointsException extends IllegalArgumentException {
    public CollinearPointsException() {
        super("Wrong coordinates. Points on one line or some points on the same coordinate.");
    }

    public CollinearPointsException(String message) {
        super(message);
    }

    public CollinearPointsException(String message, Throwable cause) {
        super(message, cause);
    }
}
