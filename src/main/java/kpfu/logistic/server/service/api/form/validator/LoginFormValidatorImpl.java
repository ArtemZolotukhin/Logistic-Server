package kpfu.logistic.server.service.api.form.validator;

import kpfu.logistic.server.service.LoginTypeRecognizer;
import kpfu.logistic.server.service.api.form.LoginForm;

import static kpfu.logistic.server.service.api.form.validator.ValidatorUtils.validateFieldByLength;

public class LoginFormValidatorImpl implements LoginFormValidator {

    private LoginTypeRecognizer loginTypeRecognizer;

    private int minPasswordLength;
    private int maxPasswordLength;
    private int minLoginLength;
    private int maxLoginLength;

    public LoginFormValidatorImpl(LoginTypeRecognizer loginTypeRecognizer, int minPasswordLength, int maxPasswordLength,
                                  int minLoginLength, int maxLoginLength) {
        this.loginTypeRecognizer = loginTypeRecognizer;
        this.minPasswordLength = minPasswordLength;
        this.maxPasswordLength = maxPasswordLength;
        this.minLoginLength = minLoginLength;
        this.maxLoginLength = maxLoginLength;
    }


    @Override
    public boolean validate(LoginForm loginForm) {
        if (loginForm == null) {
            return false;
        }

        if (validateFieldByLength(loginForm.getLogin(), minLoginLength, maxLoginLength)
                && validateFieldByLength(loginForm.getPassword(), minPasswordLength, maxPasswordLength)) {

            switch (loginTypeRecognizer.recognize(loginForm.getLogin())) {
                case LoginTypeRecognizer.TYPE_EMAIL:
                case LoginTypeRecognizer.TYPE_PHONE_NUMBER:
                    return true;
                default:
                    return false;
            }

        }

        return false;
    }
}
