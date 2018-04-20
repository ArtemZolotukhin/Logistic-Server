package kpfu.logistic.server.service.api.auth;

import kpfu.logistic.server.entity.AcceptorInfo;
import kpfu.logistic.server.entity.User;
import kpfu.logistic.server.entity.UserToken;
import kpfu.logistic.server.service.api.exceptions.InvalidFormException;
import kpfu.logistic.server.service.api.exceptions.TokenNotFoundException;
import kpfu.logistic.server.service.api.exceptions.UserNotFoundException;
import kpfu.logistic.server.service.api.form.LoginForm;

public interface AuthService {

    User getUserByToken(String token) throws UserNotFoundException, TokenNotFoundException;

    /**
     *
     * @param user
     * @param role
     * @see User for roles constants
     * @return
     */
    boolean userHasRole(User user, String role);

    /**
     *
     * @param user
     * @param role
     * @see User for roles constants
     * @return
     */
    boolean userHasOneOfRole(User user, String ... role);

    UserToken login(LoginForm loginForm) throws InvalidFormException;

    /**
     *
     * @param login
     * @return null if not found
     */
    User getByLogin(String login);

    AcceptorInfo getAcceptorInfoByUser(User user);

}
