package com.ontopoff.pool;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.lang.Math.pow;
import static java.lang.StrictMath.sqrt;
import static org.junit.jupiter.api.Assertions.*;

class EquationSolverTest {

    @Test
    void testCalculateRoots() {
        double a, b, c, x;
        a = 0;
        b = 0;
        c = 1;
        Assertions.assertEquals("Нет решений(a = 0,b = 0,c != 0)", EquationSolver.calculateRoots(a, b, c));
        c = 0;
        Assertions.assertEquals("x - любое число", EquationSolver.calculateRoots(a, b, c));
        b = 1;
        c = 1;
        x = -(b / c);
        Assertions.assertEquals(String.format("%f\n", x), EquationSolver.calculateRoots(a, b, c));
        a = 1;
        b = 0;
        c = 1;
        Assertions.assertEquals("D < 0\n", EquationSolver.calculateRoots(a, b, c));
        b = 2;
        x = (-b / (2 * a));
        Assertions.assertEquals(String.format("%f\n", x), EquationSolver.calculateRoots(a, b, c));
        b = 4;
        double discriminant = sqrt(pow(b, 2) - 4 * a * c);
        double x1 = (-b + discriminant) / (2 * a);
        double x2 = (-b - discriminant) / (2 * a);
        Assertions.assertEquals(String.format("%f, %f\n", x1, x2), EquationSolver.calculateRoots(a, b, c));
    }
}