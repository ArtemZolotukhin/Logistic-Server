package kpfu.logistic.server.service.api.converter;

import kpfu.logistic.server.entity.UserToken;
import kpfu.logistic.server.service.api.response.LoginResult;

public interface UserTokenToLoginResultConverter extends Converter<UserToken, LoginResult> {
}
