package kpfu.logistic.server.controller;


import kpfu.logistic.server.entity.UserToken;
import kpfu.logistic.server.service.api.ErrorCodes;
import kpfu.logistic.server.service.api.auth.AuthService;
import kpfu.logistic.server.service.api.converter.UserTokenToLoginResultConverter;
import kpfu.logistic.server.service.api.exceptions.InvalidFormException;
import kpfu.logistic.server.service.api.form.LoginForm;
import kpfu.logistic.server.service.api.response.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserTokenToLoginResultConverter userTokenToLoginResultConverter;

    @Autowired
    private ErrorCodes errorCodes;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiResult login(@RequestBody LoginForm loginForm) throws InvalidFormException {

        UserToken userToken = authService.login(loginForm);

        return new ApiResult()
                .setCode(errorCodes.success())
                .setBody(userTokenToLoginResultConverter.convert(userToken));

    }

}
