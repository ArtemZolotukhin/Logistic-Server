package kpfu.logistic.server.service;

import kpfu.logistic.server.service.validator.EmailValidator;
import kpfu.logistic.server.service.validator.PhoneNumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Tamerlan Shakirov
*/
@Service
public class LoginTypeRecognizerImpl implements LoginTypeRecognizer {

    @Autowired
    private EmailValidator emailValidator;

    @Autowired
    private PhoneNumberValidator phoneNumberValidator;

    /**
     * @param login
     * @return must LoginTypeRecognizer.TYPE_UNKNOWN
     * or LoginTypeRecognizer.TYPE_EMAIL
     * or LoginTypeRecognizer.TYPE_PHONE_NUMBER.
     * <p>
     * <p>
     * You MUST!!!! use EmailValidator, and PhoneNumberValidator. But you should
     * write PhoneNumberValidator before.
     * You can find EmailValidator and PhoneNumberValidator in kpfu.logistic.server.service.validator
     */
    @Override
    public int recognize(String login) {

        if (emailValidator.validate(login))
            return TYPE_EMAIL;
        else if (phoneNumberValidator.validate(login))
            return TYPE_PHONE_NUMBER;
        else
            return TYPE_UNKNOWN;

    }
}
