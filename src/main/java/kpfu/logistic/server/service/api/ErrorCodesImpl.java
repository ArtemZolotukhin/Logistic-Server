package kpfu.logistic.server.service.api;

import org.springframework.stereotype.Service;

@Service
public class ErrorCodesImpl implements ErrorCodes{

    //TODO KILL FUCKING HARDCODE

    @Override
    public int success() {
        return 0;
    }

    @Override
    public int invalidForm() {
        return 1;
    }

    @Override
    public int permissionDenied() {
        return 2;
    }

    @Override
    public int notFound() {
        return 3;
    }
}
