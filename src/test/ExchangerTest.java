import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExchangerTest {

    @Test
    @DisplayName("Exchanger function test one")
    public void testExchangeOne() {
        Exchanger exchanger = new Exchanger();

        long value = 5;
        Long[] bankM = {Long.valueOf(3), Long.valueOf(2)};
        long denomination[] = new long[bankM.length];
        int i = 0;

        long actualResult = exchanger.exchange(value,bankM, i, denomination);
        Assertions.assertEquals(1, actualResult);
    }

    @Test
    @DisplayName("Exchanger function test two")
    public void testExchangeTwo() {
        Exchanger exchanger = new Exchanger();

        long value = 5;
        Long[] bankM = {Long.valueOf(2), Long.valueOf(1)};
        long denomination[] = new long[bankM.length];
        int i = 0;

        long actualResult = exchanger.exchange(value,bankM, i, denomination);
        Assertions.assertEquals(3, actualResult);
    }
}