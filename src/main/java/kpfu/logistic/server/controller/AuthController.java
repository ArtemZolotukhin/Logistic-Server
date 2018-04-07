package kpfu.logistic.server.controller;


import kpfu.logistic.server.entity.UserToken;
import kpfu.logistic.server.service.api.AuthService;
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiResult login(@RequestBody LoginForm loginForm) throws InvalidFormException {

        //@TODO Normal error codes. Kill HARDCODE!

        UserToken userToken = authService.login(loginForm);

        return new ApiResult()
                .setCode(0)
                .setBody(userTokenToLoginResultConverter.convert(userToken));

    }

}
