package com.ontopoff.banknotes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ExchangerTest {

    @Test
    @DisplayName("exchange function test one")
    public void testExchangeOne() {
        Exchanger exchanger = new Exchanger();

        long value = 5;
        Long[] bankM = {Long.valueOf(3), Long.valueOf(2)};
        long denomination[] = new long[bankM.length];
        int i = 0;

        long actualResult = exchanger.exchange(value, bankM, i, denomination);
        Assertions.assertEquals(1, actualResult);
    }

    @Test
    @DisplayName("exchange function test two")
    public void testExchangeTwo() {
        Exchanger exchanger = new Exchanger();

        long value = 5;
        Long[] bankM = {Long.valueOf(2), Long.valueOf(1)};
        long denomination[] = new long[bankM.length];
        int i = 0;

        long actualResult = exchanger.exchange(value, bankM, i, denomination);
        Assertions.assertEquals(3, actualResult);
    }

    @Test
    @DisplayName("exchange function third two")
    public void testExchangeThree() {
        Exchanger exchanger = new Exchanger();

        long value = 10000;
        Long[] bankM = {Long.valueOf(5000), Long.valueOf(3434), Long.valueOf(1103), Long.valueOf(1100), Long.valueOf(343), Long.valueOf(195), Long.valueOf(103), Long.valueOf(99)};
        long denomination[] = new long[bankM.length];
        int i = 0;

        long actualResult = exchanger.exchange(value, bankM, i, denomination);
        Assertions.assertEquals(2423, actualResult);
    }
}