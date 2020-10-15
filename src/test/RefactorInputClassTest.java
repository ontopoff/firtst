import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.util.ArrayList;

class RefactorInputClassTest {


    @ParameterizedTest
    @DisplayName("Exchangeable function Exception test")
    @ValueSource(strings = {"Hello ","-fds"," -+"," 0" ,"FSD", ".432","   ", "-5"})
    public void throwsExceptionExchangeable(String strValue) {
        RefactorInputClass refactorInput = new RefactorInputClass();

        Assertions.assertThrows(NumberFormatException.class, () -> refactorInput.exchangeable(strValue));
    }

    @Test
    @DisplayName("Exchangeable function test")
    public void testExchangeable() throws IOException {
        RefactorInputClass refactorInput = new RefactorInputClass();
        String[] strValue = {"25", "25.5", "25,6", "25.gdfgdgd+gdfa5"};
        for(String value : strValue) {
            long result = refactorInput.exchangeable(value);
            Assertions.assertEquals(25, result);
        }
    }

    @ParameterizedTest
    @DisplayName("Changer function test NumberFormatException")
    @ValueSource(strings = {"Hello ","-fds"," -+"," 0" ,"FSD", ".432","   ", " -5"})
    public void throwsNumberFormatExceptionChanger(String strValue) {
        RefactorInputClass refactorInput = new RefactorInputClass();

        Assertions.assertThrows(NumberFormatException.class, () -> refactorInput.changer(0, false, strValue));
    }

    @Test
    @DisplayName("Changer function test GreaterNumberException")
    public void throwsGreaterNumberExceptionChanger() {
        RefactorInputClass refactorInput = new RefactorInputClass();
        long value = 1;
        for(int i = 11; i > value; --i) {
            String strValue = String.valueOf(i);
            Assertions.assertThrows(GreaterNumberException.class, () -> refactorInput.changer(value, true, strValue));
        }
    }

    @Test
    @DisplayName("NullArrayCheck function test NullArrayListException")
    public void throwsNullArrayListExceptionNullArrayCheck() {
        RefactorInputClass refactorInput = new RefactorInputClass();
        ArrayList<Long> inputList = new ArrayList();
        Assertions.assertThrows(NullArrayListException.class, () -> refactorInput.nullArrayCheck(inputList));

    }

}