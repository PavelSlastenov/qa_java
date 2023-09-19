package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Test
    public void getSoundCatShouldReturnValue() {
        Feline feline = Mockito.mock(Feline.class);
        Cat cat = new Cat(feline);
        String expectedResult = "Мяу";
        String actualResult = cat.getSound();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getMeatCatShouldReturnValue() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Cat cat = new Cat(feline);
        when(feline.eatMeat()).thenReturn(Arrays.asList("Животные", "123"));
        List<String> expectedResult = Arrays.asList("Животные", "123");
        List<String> actualResult = cat.getFood();

        assertEquals(expectedResult, actualResult);
    }
}