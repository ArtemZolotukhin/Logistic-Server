package kpfu.logistic.server.service.api.form.validator;

import kpfu.logistic.server.service.LoginTypeRecognizer;
import kpfu.logistic.server.service.api.form.PackageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PackageFormValidatorImpl implements PackageFormValidator {

    @Autowired
    private LoginTypeRecognizer loginTypeRecognizer;

    @Override
    public boolean validate(PackageForm packageForm) {
        if (packageForm == null) {
            return false;
        }

        // TODO Kill HARDCODE
        return (packageForm.getVolume() != null)
                && (packageForm.getVolume() >= 0)
                && (packageForm.getDestinationId() != null)
                && ValidatorUtils.validateFieldByLength(packageForm.getConsumerPhone(), 1, 16)
                && (loginTypeRecognizer.recognize(packageForm.getConsumerPhone()) == LoginTypeRecognizer.TYPE_PHONE_NUMBER);
    }
}
