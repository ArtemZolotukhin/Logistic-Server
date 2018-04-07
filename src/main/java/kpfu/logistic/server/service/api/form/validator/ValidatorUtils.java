package kpfu.logistic.server.service.api.form.validator;

public class ValidatorUtils {

    public static boolean validateFieldByLength(String string, int minLength, int maxLength) {
        if (string == null) {
            return minLength == 0;
        } else {
            if (string.length() < minLength) {
                return false;
            } else {
                if (string.length() > maxLength) {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean isWhiteSpace(char c) {
        return c == ' ' || c == '\t' || c == '\n';
    }

}
