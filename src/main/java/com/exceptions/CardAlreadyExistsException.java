package com.exceptions;

public class CardAlreadyExistsException  extends RuntimeException {
    private static final long serialVersionUID = -5836180738846127210L;
    private final String message;

    /**
     * @param message
     */
    public CardAlreadyExistsException(String message) {
        this.message = message;
    }

    /**
     * @return
     */
    @Override
    public String getMessage() {
        return message;
    }
}

