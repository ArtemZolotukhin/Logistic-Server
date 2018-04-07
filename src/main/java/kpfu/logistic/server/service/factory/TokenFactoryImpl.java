package kpfu.logistic.server.service.factory;


import kpfu.logistic.server.entity.User;
import kpfu.logistic.server.entity.UserToken;
import kpfu.logistic.server.service.StringTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenFactoryImpl implements TokenFactory{

    @Autowired
    private StringTokenGenerator stringTokenGenerator;

    @Override
    public UserToken createToken(User user) {

        UserToken userToken = new UserToken();
        userToken.setToken(stringTokenGenerator.generate());
        userToken.setUser(user);

        return userToken;
    }
}
