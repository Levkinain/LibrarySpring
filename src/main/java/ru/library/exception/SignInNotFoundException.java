package ru.library.exception;

@SuppressWarnings("serial")
public final class SignInNotFoundException extends AccountException {

    private final String login;

    public SignInNotFoundException(String login) {
        super("login not found");
        this.login = login;
    }

    public String getUsername() {
        return login;
    }

}

