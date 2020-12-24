package com.ontopoff.pool;

import java.io.FileWriter;

public class Equation {

    public static void main(String[] args) {
        int filePoolSize = Runtime.getRuntime().availableProcessors();
        int threadPoolSize = Runtime.getRuntime().availableProcessors();
        if(args.length == 2) {
            filePoolSize = Integer.parseInt(args[0]);
            threadPoolSize = Integer.parseInt(args[1]);
        }
        int waitingTimeInMillis = 1000;
        int start, end;
        double[] coefficientA = new double[10000];
        double[] coefficientB = new double[10000];
        double[] coefficientC = new double[10000];
        for (int i = 0; i < 10000; i++) {
            coefficientA[i] = (Math.random() * (10000 + 1)) - 5000;
            coefficientB[i] = (Math.random() * (10000 + 1)) - 5000;
            coefficientC[i] = (Math.random() * (10000 + 1)) - 5000;
        }

        ResourcePool<Thread> threadPool = new ResourcePool<>(threadPoolSize, waitingTimeInMillis, new CreateThreadClass());
        ResourcePool<FileWriter> filePool = new ResourcePool<>(filePoolSize, waitingTimeInMillis, new CreateFileClass());

        for (int i = 0; i < filePoolSize; i++) {
            start = (i * 10000) / filePoolSize;
            end = ((i + 1) * 10000) / filePoolSize;
            EquationSolver solverThread = new EquationSolver(coefficientA, coefficientB, coefficientC, start, end, filePool, threadPool);
            solverThread.execute(solverThread);
        }
        threadPool.shutdown();
    }
}
