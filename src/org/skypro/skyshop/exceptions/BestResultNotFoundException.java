package org.skypro.skyshop.exceptions;

public class BestResultNotFoundException extends Exception {
    public BestResultNotFoundException() {
    }

    public BestResultNotFoundException(String message) {
        super(message);
    }

    public BestResultNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BestResultNotFoundException(Throwable cause) {
        super(cause);
    }
}
