package kpfu.logistic.server.service.api.auth;


import kpfu.logistic.server.entity.AcceptorInfo;
import kpfu.logistic.server.entity.User;
import kpfu.logistic.server.entity.UserToken;
import kpfu.logistic.server.repository.UserRepository;
import kpfu.logistic.server.repository.UserTokenRepository;
import kpfu.logistic.server.service.Crypter;
import kpfu.logistic.server.service.LoginTypeRecognizer;
import kpfu.logistic.server.service.PasswordGenerator;
import kpfu.logistic.server.service.StringTokenGenerator;
import kpfu.logistic.server.service.api.exceptions.InvalidFormException;
import kpfu.logistic.server.service.api.exceptions.TokenNotFoundException;
import kpfu.logistic.server.service.api.exceptions.UserNotFoundException;
import kpfu.logistic.server.service.api.form.LoginForm;
import kpfu.logistic.server.service.api.form.validator.LoginFormValidator;
import kpfu.logistic.server.service.factory.TokenFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserTokenRepository userTokenRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginFormValidator loginFormValidator;

    @Autowired
    private LoginTypeRecognizer loginTypeRecognizer;

    @Autowired
    private TokenFactory tokenFactory;

    @Autowired
    private StringTokenGenerator stringTokenGenerator;

    @Autowired
    private Crypter crypter;


    @Override
    public User getUserByToken(String token) throws UserNotFoundException, TokenNotFoundException {

        UserToken userToken = userTokenRepository.findOneByToken(token);

        if (userToken == null) {
            throw new TokenNotFoundException();
        }


        User user = userToken.getUser();

        if (user != null) {
            return user;
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public boolean userHasRole(User user, String role) {
        return user.getRole().compareToIgnoreCase(role) == 0;
    }

    @Override
    public boolean userHasOneOfRole(User user, String... role) {
        for (String i : role) {
            if (userHasRole(user, i)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public UserToken login(LoginForm loginForm) throws InvalidFormException {

        if (loginFormValidator.validate(loginForm)) {

            User user = null;

            String login = loginForm.getLogin();
            String passwordCrypted = crypter.crypt(loginForm.getPassword());

            switch (loginTypeRecognizer.recognize(loginForm.getLogin())) {
                case LoginTypeRecognizer.TYPE_EMAIL:
                    user = userRepository.findOneByEmailAndPasswordCrypted(
                            login,
                            passwordCrypted
                    );
                    break;
                case LoginTypeRecognizer.TYPE_PHONE_NUMBER:
                    user = userRepository.findOneByPhoneNumberAndPasswordCrypted(
                            login,
                            passwordCrypted
                    );
                    break;
            }

            if (user != null) {
                return createOrUpdateUserToken(user);
            }
        }

        throw new InvalidFormException();

    }

    @Override
    public User getByLogin(String login) {
        switch (loginTypeRecognizer.recognize(login)) {
            case LoginTypeRecognizer.TYPE_EMAIL:
                return userRepository.findOneByEmail(login);
            case LoginTypeRecognizer.TYPE_PHONE_NUMBER:
                return userRepository.findOneByPhoneNumber(login);
            default:
                return null;
        }
    }

    @Override
    public AcceptorInfo getAcceptorInfoByUser(User user) {
        AcceptorInfo acceptorInfo = userRepository.acceptorInfoByUser(user);
        return acceptorInfo;
    }


    private UserToken createOrUpdateUserToken(User user) {
        UserToken token = user.getToken();
        if (token == null) {
            token = tokenFactory.createToken(user);
        } else {
            token.setToken(stringTokenGenerator.generate());
        }
        userTokenRepository.saveAndFlush(token);

        return token;
    }
}
