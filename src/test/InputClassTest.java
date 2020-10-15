import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

class RefactorInputClassTest {

    @ParameterizedTest
    @ValueSource(strings = {"Hello ","fdsfdsf","-fds"," -+"," 0", "0" ,"0" ,"fsdff"})
    public void throwsExceptionInputExchangeable(String strValue) {
        RefactorInputClass refactorInput = new RefactorInputClass();

        Assertions.assertThrows(NumberFormatException.class, () -> refactorInput.exchangeable(strValue));
    }

}