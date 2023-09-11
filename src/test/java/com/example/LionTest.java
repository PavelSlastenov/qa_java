package com.example;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {

    @Test
    public void constructorWithMaleSexLionShouldReturnValue() throws Exception {
        String sex = "Самец";

        Lion lion = new Lion(sex);

        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void constructorWithFemaleSexLionShouldReturnValue() throws Exception {
        String sex = "Самка";

        Lion lion = new Lion(sex);

        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void constructorWithInvalidSexLionShouldReturnValue() {
        String sex = "Некорректный пол";

        Exception exception = assertThrows(Exception.class, () -> new Lion(sex));

        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }

    @Test
    public void getKittensLionShouldReturnValue() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        when(mockFeline.getKittens()).thenReturn(2);

        Lion lion = new Lion("Самец");
        lion.feline = mockFeline;

        int actualKittens = lion.getKittens();

        assertEquals(2, actualKittens);
    }

    @Test
    public void doesHaveManeLionShouldReturnValue() throws Exception {
        String sex = "Самец";

        Lion lion = new Lion(sex);

        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void getFoodLionShouldReturnValue() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        List<String> expectedFood = List.of("Мясо");
        when(mockFeline.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion("Самец");
        lion.feline = mockFeline;

        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
    }
}
