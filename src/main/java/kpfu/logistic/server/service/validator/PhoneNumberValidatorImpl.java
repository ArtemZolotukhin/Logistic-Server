package kpfu.logistic.server.service.validator;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PhoneNumberValidatorImpl implements PhoneNumberValidator {

    @Override
    public boolean validate(String phoneNumber) {

        if (phoneNumber == null) {
            return false;
        }

        Pattern p = Pattern.compile("^[8]{1}[0-9]{10}$");
        Matcher m = p.matcher(phoneNumber);

        return m.matches();
    }
}