package com.ontopoff.banknotes;

public class Exchanger {


     public long exchange(long value, Long bankM[], int i, long denomination[]) {
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
}
