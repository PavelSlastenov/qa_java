package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final boolean expectedResult;

    Feline feline;

    public LionTest(String sex, boolean expectedResult) {
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
        Lion lion = new Lion (sex, feline);
        Assert.assertEquals(expectedResult, lion.doesHaveMane());
    }

    @Test
    public void constructorWithInvalidSexLionShouldReturnValue() {
        String sex = "Некорректный пол";
        Exception exception = assertThrows(Exception.class, () -> new Lion(sex, feline));

        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }

    @Test
    public void getKittensLionShouldReturnValue() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        when(mockFeline.getKittens()).thenReturn(2);

        Lion lion = new Lion("Самец", feline);
        lion.feline = mockFeline;

        int actualKittens = lion.getKittens();

        assertEquals(2, actualKittens);
    }

    @Test
    public void doesHaveManeLionShouldReturnValue() throws Exception {
        String sex = "Самец";
        Lion lion = new Lion(sex, feline);

        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void getFoodLionShouldReturnValue() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        List<String> expectedFood = List.of("Мясо");
        when(mockFeline.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", feline);
        lion.feline = mockFeline;

        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
    }
}
