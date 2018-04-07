package kpfu.logistic.server.service.api.exceptions;

public class TokenNotFoundException extends Exception {
    public TokenNotFoundException() {
        super();
    }

    public TokenNotFoundException(String s) {
        super(s);
    }

    public TokenNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public TokenNotFoundException(Throwable throwable) {
        super(throwable);
    }
}
