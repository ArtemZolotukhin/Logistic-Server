package kpfu.logistic.server.config;

import kpfu.logistic.server.service.LoginTypeRecognizer;
import kpfu.logistic.server.service.api.form.validator.LoginFormValidator;
import kpfu.logistic.server.service.api.form.validator.LoginFormValidatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidatorConfig {

    @Autowired
    @Bean
    public LoginFormValidator loginFormValidator(LoginTypeRecognizer loginTypeRecognizer) {
        return new LoginFormValidatorImpl(loginTypeRecognizer, 6, 64, 1, 256);
    }
}
