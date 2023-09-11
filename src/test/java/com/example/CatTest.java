package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundCatShouldReturnValue() throws Exception {
        Cat cat = new Cat(feline);

        Mockito.when(feline.getKittens()).thenReturn(1);
//        Mockito.when(feline.getFamily()).thenReturn("Кошачьи");
        Mockito.when(feline.eatMeat()).thenReturn(Arrays.asList("Животные", "123"));

        String expectedResult = "Мяу";
        String actualResult = cat.getSound();

        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void getMeatCatShouldReturnValue() throws Exception {
        Cat cat = new Cat(feline);

        Mockito.when(feline.eatMeat()).thenReturn(Arrays.asList("Животные", "123"));

        List<String> expectedResult = Arrays.asList("Животные", "123");
        List<String> actualResult = cat.getFood();

        assertEquals(expectedResult, actualResult);

    }

}