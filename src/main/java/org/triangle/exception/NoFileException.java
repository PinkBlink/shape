package org.triangle.exception;

import java.io.IOException;

public class NoFileException extends IOException {
    public NoFileException(String message) {
        super(message);
    }

    public NoFileException() {
        super("Problems with the file or path.");
    }
}
