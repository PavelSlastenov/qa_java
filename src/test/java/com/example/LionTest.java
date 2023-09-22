package com.example;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class LionTest {

    @Test(expected = Exception.class)
    public void constructorWithInvalidSexLionShouldThrowException() throws Exception {
        String sex = "Некорректный пол";
        Feline mockFeline = Mockito.mock(Feline.class);
        new Lion(sex, mockFeline);
    }

    @Test
    public void getKittensLionShouldReturnValue() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        when(mockFeline.getKittens()).thenReturn(2);

        Lion lion = new Lion("Самец", mockFeline);

        int actualKittens = lion.getKittens();

        assertEquals(2, actualKittens);
    }

    @Test
    public void doesHaveManeLionShouldReturnValue() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самец", mockFeline);

        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void getFoodLionShouldReturnValue() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        List<String> expectedFood = List.of("Мясо");
        when(mockFeline.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", mockFeline);

        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
    }
}
