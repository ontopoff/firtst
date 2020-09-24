import java.util.Scanner;

public class Banknotes {

    static long exchange(long value, long bankM[], int i, long denomination[]) {
        long temp = 0;
        if(value == 0) {
                for(int j = 0; j < denomination.length; ++j) {
                    if(denomination[j] != 0) {
                        for(int k = 0; k < denomination[j]; ++k) System.out.print(bankM[j] + " ");
                    }
                }
                System.out.println("");
                return 1;
        }
        for(int j = i; j < bankM.length; ++j) {
            if(value / bankM[j] > 0)
                    for (long k = value / bankM[j]; k > 0; --k) {
                        value -= bankM[j] * k;
                        denomination[j] += k;
                        temp += exchange(value, bankM, j + 1, denomination);
                        denomination[j] -= k;
                        value += bankM[j] * k;
                    }
            }
        return temp;
    }

    public static void main(String[] args) {
        long res = 0;
        Scanner myObj = new Scanner(System.in);
        long value = myObj.nextLong();
        int n = myObj.nextInt();
        long bankM[] = new long[n];
        long denomination[] = new long[n];
        for(int i = 0; i < bankM.length; ++i) {
            bankM[i] = myObj.nextLong();
        }
        //for(int i = 0; i < bankM.length; ++i) {
            //if(value / bankM[i] > 0) {
                //System.out.println(i+ "------------------");
                res += exchange(value, bankM, 0, denomination);
                //--denomination[i];
            //}
        //}
        System.out.println(res);
    }
}
