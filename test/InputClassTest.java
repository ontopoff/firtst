import com.ontopoff.banknotes.InputClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


class InputClassTest {

    @ParameterizedTest
    @DisplayName("inputExchangeable function Exception test")
    @ValueSource(strings = {"Hello ","-fds"," -+"," 0" ,"FSD", ".432","   ", "-5"})
    public void throwsExceptionExchangeable(String strValue) {
        InputClass input = new InputClass();
        InputStream stream = new ByteArrayInputStream(strValue.getBytes());

        Assertions.assertThrows(NumberFormatException.class, () -> input.inputExchangeable(stream));
    }


    @ParameterizedTest
    @DisplayName("inputExchangeable function test")
    @ValueSource(strings = {"25", "25.5", "25,6", "25,gfgdfdg", "25.0", "25,--gdf-gfd-gd  -gdf g-fd"})
    void testInputExchangeable(String strValue) throws IOException {
        InputClass input = new InputClass();
        InputStream stream = new ByteArrayInputStream(strValue.getBytes());
        Long actRes = input.inputExchangeable(stream);
        Assertions.assertEquals(25, actRes);
    }

    @ParameterizedTest
    @DisplayName("inputChanger function test")
    @ValueSource(strings = {"25 5 5 7 7 0 3", "FDS + 55 5 5 5 3 2 1", "1.5454 2.43243 3.43243 4"})
    void testInputChanger(String strValue) throws IOException {
        InputClass input = new InputClass();
        InputStream stream = new ByteArrayInputStream(strValue.getBytes());
        Long[] actRes = input.inputChanger(stream, 25);
        Assertions.assertEquals(4, actRes.length);
    }

}