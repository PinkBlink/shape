package org.triangle.exception;

import java.io.IOException;

public class NoFileException extends IOException {
    public NoFileException() {
        super("Problems with the file or path.");
    }

    public NoFileException(String message) {
        super(message);
    }

    public NoFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
