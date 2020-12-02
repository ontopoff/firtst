package com.ontopoff.listDir;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

class FileOutputClassTest {

    @Test
    void testExceptionOpenOutputFile() {
        FileOutputClass fileOutput = new FileOutputClass();
        try {
            File outPutDir = new File("./dir").getCanonicalFile();
            outPutDir.mkdir();

            String filePath = "./dir/output.txt";
            File outputFile = new File(filePath).getCanonicalFile();
            if (outputFile.exists()) {
                outputFile.delete();
            }

            Assertions.assertThrows(FileNotFoundException.class, () -> fileOutput.checkFile(filePath));
            outPutDir.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}