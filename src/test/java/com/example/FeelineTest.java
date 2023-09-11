package com.example;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class FeelineTest {

    @Test
    public void getEatMeatFeelineShouldReturnValue() throws Exception {
        Feline feline = new Feline();

        List<String> expectedFood = List.of("Мясо");
        Feline mockFeline = Mockito.spy(feline);
        doReturn(expectedFood).when(mockFeline).getFood("Хищник");

        List<String> actualFood = mockFeline.eatMeat();

        verify(mockFeline, times(1)).getFood("Хищник");

        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void getFamilyFeelineShouldReturnValue() {
        Feline feline = new Feline();

        String actualFamily = feline.getFamily();

        // Проверяем, что возвращенное значение соответствует ожидаемому
        assertEquals("Кошачьи", actualFamily);
    }

    @Test
    public void getKittensFeelineShouldReturnValue() {
        Feline feline = new Feline();

        int actualKittens = feline.getKittens();

        // Проверяем, что возвращенное значение соответствует ожидаемому
        assertEquals(1, actualKittens);
    }

    @Test
    public void getKittensWithCountFeelineShouldReturnValue() {
        Feline feline = new Feline();
        int kittensCount = 3;

        int actualKittens = feline.getKittens(kittensCount);

        // Проверяем, что возвращенное значение соответствует ожидаемому
        assertEquals(kittensCount, actualKittens);
    }

}
