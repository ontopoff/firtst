package com.ontopoff.pool;

import java.io.FileWriter;
import java.io.IOException;

import static java.lang.Math.*;

public class EquationSolver implements Runnable {
    double[] coefficientA;
    double[] coefficientB;
    double[] coefficientC;
    int start, end;
    ResourcePool<FileWriter> filePool;
    ResourcePool<Thread> threadPool;

    public EquationSolver(double[] a, double[] b, double[] c, int s, int e, ResourcePool<FileWriter> filePool, ResourcePool<Thread> threadPool) {
        coefficientA = a;
        coefficientB = b;
        coefficientC = c;
        start = s;
        end = e;
        this.filePool = filePool;
        this.threadPool = threadPool;
    }

    @Override
    public void run() {
        try (FileWriter logWriter = filePool.acquire()) {
            for (int i = start; i < end; i++) {
                String roots = calculateRoots(coefficientA[i], coefficientB[i], coefficientC[i]);
                logWriter.write(roots);
            }
            filePool.returnBack(logWriter);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void execute(Runnable runnable) {
        Thread worker = threadPool.acquire();
        doExecute(runnable, worker);
        threadPool.returnBack(worker);
    }

    private void doExecute(Runnable runnable, Thread worker) {
        try {
            runnable.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static String calculateRoots(double a, double b, double c) {
        double discriminant = pow(b, 2) - 4 * a * c;
        if (discriminant < 0) {
            return "D < 0\n";
        }
        if (a == 0) {
            double x;
            if(b != 0) {
                x = -(c / b);
                return String.format("%f\n", x);
            } else {
                if(c == 0) {
                    return "x - любое число";
                } else {
                    return "Нет решений(a = 0,b = 0,c = 0)";
                }
            }
        }
        if (discriminant == 0) {
            double x = (-b / (2 * a));
            return String.format("%f\n", x);
        }
        discriminant = sqrt(discriminant);
        double x1 = (-b + discriminant) / (2 * a);
        double x2 = (-b - discriminant) / (2 * a);
        return String.format("%f, %f\n", x1, x2);
    }
}
