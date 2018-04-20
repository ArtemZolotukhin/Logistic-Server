package kpfu.logistic.server.service.api.exceptions;

public class StorageNotFoundException extends Exception{

    public StorageNotFoundException() {
        super();
    }

    public StorageNotFoundException(String s) {
        super(s);
    }

    public StorageNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public StorageNotFoundException(Throwable throwable) {
        super(throwable);
    }
}
