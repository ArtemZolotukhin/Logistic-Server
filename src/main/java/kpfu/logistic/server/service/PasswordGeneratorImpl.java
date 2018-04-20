package kpfu.logistic.server.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PasswordGeneratorImpl implements PasswordGenerator{

    @Override
    public String generate(int length) {

        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < length; i++) {
            stringBuffer.append((char) random.nextInt('z' - 'a'));
        }
        return stringBuffer.toString();
    }
}
