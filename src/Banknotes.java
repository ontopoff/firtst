import java.io.IOException;

public class Banknotes {

    public static void main(String[] args) throws IOException {
        long res = 0;

        InputClass input = new InputClass();
        Exchanger func = new Exchanger();

        long value = input.inputExchangeable();
        Long[] bankM = input.Inputchanger(value);
        long denomination[] = new long[bankM.length];

        res = func.exchange(value, bankM, 0, denomination);
        System.out.println(res);
    }
}
