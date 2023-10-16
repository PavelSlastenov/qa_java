package com.example;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class FeelineTest {

    @Test
    public void getEatMeatFeelineShouldReturnValue() throws Exception {
        Feline feline = Mockito.spy(new Feline());

        List<String> expectedFood = List.of("Мясо");
        doReturn(expectedFood).when(feline).getFood("Хищник");
        List<String> actualFood = feline.eatMeat();

        verify(feline, times(1)).getFood("Хищник");

        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void getFamilyFeelineShouldReturnValue() {
        Feline feline = new Feline();
        String actualFamily = feline.getFamily();

        assertEquals("Кошачьи", actualFamily);
    }

    @Test
    public void getKittensFeelineShouldReturnValue() {
        Feline feline = new Feline();
        int actualKittens = feline.getKittens();

        assertEquals(1, actualKittens);
    }

    @Test
    public void getKittensWithCountFeelineShouldReturnValue() {
        Feline feline = new Feline();
        int kittensCount = 3;
        int actualKittens = feline.getKittens(kittensCount);

        assertEquals(kittensCount, actualKittens);
    }
}
