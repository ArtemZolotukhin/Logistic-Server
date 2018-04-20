package kpfu.logistic.server.controller;

import kpfu.logistic.server.service.api.ErrorCodes;
import kpfu.logistic.server.service.api.exceptions.InvalidFormException;
import kpfu.logistic.server.service.api.response.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlingController {

    @Autowired
    private ErrorCodes errorCodes;

    @ExceptionHandler(InvalidFormException.class)
    public ApiResult invalidForm() {
        return new ApiResult().setCode(errorCodes.invalidForm());
    }

}
