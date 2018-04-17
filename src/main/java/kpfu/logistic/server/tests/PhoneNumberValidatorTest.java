package kpfu.logistic.server.tests;

import kpfu.logistic.server.service.validator.PhoneNumberValidatorImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class PhoneNumberValidatorTest {

    @Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][]{
                {"89604562464", true}, {"12345678901", false}
        });
    }

    private boolean expectedTest;
    private String inputTest;
    public PhoneNumberValidatorTest (String input, boolean expected) {
        inputTest = input;
        expectedTest = expected;
    }

    @Test
    public void numberIsValid() {
        PhoneNumberValidatorImpl p = new PhoneNumberValidatorImpl ();
        Assert.assertEquals(expectedTest, p.validate(inputTest));
    }
}