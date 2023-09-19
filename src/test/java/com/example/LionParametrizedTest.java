package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class LionParametrizedTest {

    private final String sex;
    private final boolean expectedResult;

    public LionParametrizedTest(String sex, boolean expectedResult) {
        this.sex = sex;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex);
        lion.setFeline(mockFeline);

        Assert.assertEquals(expectedResult, lion.doesHaveMane());
    }
}