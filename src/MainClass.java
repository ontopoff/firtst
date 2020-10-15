import java.io.IOException;

public class MainClass {

    public static void main(String[] args) throws IOException {
        long res = 0;

        InputClass input = new InputClass();
        Exchanger func = new Exchanger();

        long value = input.inputExchangeable(System.in);
        Long[] bankM = input.InputChanger(System.in, value);
        long denomination[] = new long[bankM.length];

        res = func.exchange(value, bankM, 0, denomination);
        System.out.println(res);
    }
}
