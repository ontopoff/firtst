package com.ontopoff.banknotes;

import java.io.IOException;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) throws IOException {
        long res;


        InputClass input = new InputClass();
        Scanner askToStart = new Scanner(System.in);
        Exchanger func = new Exchanger();

        System.out.print("Введите сумму для размена: ");
        long value = input.inputExchangeable(System.in);
        System.out.print("Введите номиналы для размена: ");
        Long[] bankM = input.inputChanger(System.in, value);
        long denomination[] = new long[bankM.length];


        System.out.println("Введенные данные: ");
        System.out.println("Сумма: " + value);
        System.out.print("Номиналы:");
        for (int i = 0; i < bankM.length; ++i) {
            System.out.print(" " + bankM[i]);
        }
        System.out.println("");
        System.out.println("Запустить программу?(y/n)");
        String start = askToStart.nextLine();
        while(true) {
            if(start.equals("y")) {
                break;
            } else if(start.equals("n")) {
                return;
            } else {
                System.out.println("Запустить программу?(y/n)");
                start = askToStart.nextLine();
            }
        }


        System.out.println("Комбинации: ");
        res = func.exchange(value, bankM, 0, denomination);
        System.out.println("Количество комбинаций: " + res);
    }
}
