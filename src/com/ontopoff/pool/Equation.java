package com.ontopoff.pool;

import java.io.FileWriter;

public class Equation {

    public static void main(String[] args) {
        int poolSize = 5;
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

        ResourcePool<Thread> threadPool = new ResourcePool<>(poolSize, waitingTimeInMillis, new CreateThreadClass());
        ResourcePool<FileWriter> filePool = new ResourcePool<>(poolSize, waitingTimeInMillis, new CreateFileClass());

        for (int i = 0; i < poolSize; i++) {
            start = (i * 10000) / poolSize;
            end = ((i + 1) * 10000) / poolSize;
            EquationSolver solverThread = new EquationSolver(coefficientA, coefficientB, coefficientC, start, end, filePool, threadPool);
            solverThread.execute(solverThread);
        }
        threadPool.shutdown();
    }
}
