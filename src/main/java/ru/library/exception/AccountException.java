package ru.library.exception;

@SuppressWarnings("serial")
public abstract class AccountException extends Exception {

    public AccountException(String message) {
        super(message);
    }

    public AccountException(String message, Throwable cause) {
        super(message, cause);
    }

}
