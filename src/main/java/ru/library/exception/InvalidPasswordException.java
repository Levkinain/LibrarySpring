package ru.library.exception;

@SuppressWarnings("serial")
public final class InvalidPasswordException extends AccountException {

    public InvalidPasswordException() {
        super("invalid password");
    }
}

