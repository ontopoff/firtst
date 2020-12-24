package com.ontopoff.pool;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


class EquationTest {

    @Test
    void testMainLogSize() {
        String[] poolSizes = {"2", "4"};
        Equation.main(poolSizes);
        String fileLogPath = System.getProperty("user.dir") + File.separator + "Log";
        File dir = new File(fileLogPath);
        File[] arrFiles = dir.listFiles();
        List<File> lstFiles = Arrays.asList(arrFiles);
        Assertions.assertEquals(2, lstFiles.size());
    }

    @Test
    void testMainLogFilesSize() {
        String[] poolSizes = {"2", "4"};
        Equation.main(poolSizes);
        String fileLogPath = System.getProperty("user.dir") + File.separator + "Log";
        File dir = new File(fileLogPath);
        File[] arrFiles = dir.listFiles();
        List<File> lstFiles = Arrays.asList(arrFiles);
        for (File outputFile : lstFiles) {
            Stream<String> lines = null;
            try {
                lines = Files.lines(outputFile.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            Assertions.assertEquals(5000, lines.count());
        }
    }

}