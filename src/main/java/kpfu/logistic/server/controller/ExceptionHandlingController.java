package kpfu.logistic.server.controller;

import kpfu.logistic.server.service.api.exceptions.InvalidFormException;
import kpfu.logistic.server.service.api.response.ApiResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(InvalidFormException.class)
    public ApiResult invalidForm() {
        //@TODO kill hardcode
        return new ApiResult().setCode(1);
    }

}
