import com.ontopoff.banknotes.GreaterNumberException;
import com.ontopoff.banknotes.NullArrayListException;
import com.ontopoff.banknotes.RefactorInputClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

class RefactorInputClassTest {


    @ParameterizedTest
    @DisplayName("changer function test NumberFormatException")
    @ValueSource(strings = {"Hello ","-fds"," -+"," 0" ,"FSD", ".432","   ", " -5"})
    public void throwsNumberFormatExceptionChanger(String strValue) {
        RefactorInputClass refactorInput = new RefactorInputClass();

        Assertions.assertThrows(NumberFormatException.class, () -> refactorInput.changer(0, false, strValue));
    }

    @Test
    @DisplayName("changer function test com.ontopoff.banknotes.GreaterNumberException")
    public void throwsGreaterNumberExceptionChanger() {
        RefactorInputClass refactorInput = new RefactorInputClass();
        long value = 1;
        for(int i = 11; i > value; --i) {
            String strValue = String.valueOf(i);
            Assertions.assertThrows(GreaterNumberException.class, () -> refactorInput.changer(value, true, strValue));
        }
    }

    @Test
    @DisplayName("nullArrayCheck function test com.ontopoff.banknotes.NullArrayListException")
    public void throwsNullArrayListExceptionNullArrayCheck() {
        RefactorInputClass refactorInput = new RefactorInputClass();
        ArrayList<Long> inputList = new ArrayList();
        Assertions.assertThrows(NullArrayListException.class, () -> refactorInput.nullArrayCheck(inputList));

    }

}