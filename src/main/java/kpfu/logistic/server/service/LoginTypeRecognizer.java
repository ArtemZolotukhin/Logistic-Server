package kpfu.logistic.server.service;

public interface LoginTypeRecognizer {

    int TYPE_UNKNOWN = -1;
    int TYPE_EMAIL = 1;
    int TYPE_PHONE_NUMBER = 2;

    /**
     *
     * @param login
     * @return TYPE_UNKNOWN, TYPE_EMAIL, TYPE_PHONE_NUMBER
     */
    int recognize(String login);


}
