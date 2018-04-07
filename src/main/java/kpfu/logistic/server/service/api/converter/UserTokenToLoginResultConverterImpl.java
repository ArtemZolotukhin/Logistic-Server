package kpfu.logistic.server.service.api.converter;

import kpfu.logistic.server.entity.UserToken;
import kpfu.logistic.server.service.api.response.LoginResult;
import org.springframework.stereotype.Service;

@Service
public class UserTokenToLoginResultConverterImpl implements UserTokenToLoginResultConverter{

    @Override
    public LoginResult convert(UserToken userToken) {

        LoginResult loginResult = new LoginResult();
        loginResult.setToken(userToken.getToken());
        loginResult.setUserId(Long.toString(userToken.getUser().getId()));

        return loginResult;
    }
}
