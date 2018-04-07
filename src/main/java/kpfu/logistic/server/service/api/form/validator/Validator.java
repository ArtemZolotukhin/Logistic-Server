package kpfu.logistic.server.service.api.form.validator;

public interface Validator<T> {

    boolean validate(T t);

}
