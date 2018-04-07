package kpfu.logistic.server.service.api.exceptions;

public class InvalidFormException extends Exception {
    public InvalidFormException() {
    }

    public InvalidFormException(String s) {
        super(s);
    }

    public InvalidFormException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public InvalidFormException(Throwable throwable) {
        super(throwable);
    }
}
