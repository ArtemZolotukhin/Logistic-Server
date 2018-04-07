package kpfu.logistic.server.service.factory;

import kpfu.logistic.server.entity.User;
import kpfu.logistic.server.entity.UserToken;

public interface TokenFactory {

    UserToken createToken(User user);

}
