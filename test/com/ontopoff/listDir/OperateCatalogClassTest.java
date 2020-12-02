package com.ontopoff.listDir;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class OperateCatalogClassTest {

    @Test
    void testExceptionOpenDistDir() {
        OperateCatalogClass operateCatalog = new OperateCatalogClass();
        try {
            File dir = new File("./dir").getCanonicalFile();
            if (dir.exists()) {
                dir.delete();
            }

            String outputPath = "output.txt";
            File outputFile = new File(outputPath).getCanonicalFile();
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }
            FileOutputClass fOut = new FileOutputClass();

            Assertions.assertThrows(NullPointerException.class, () -> operateCatalog.displayAll(dir, 0, outputPath, fOut));
            outputFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testDisplayAllMethod() {
        OperateCatalogClass operateCatalog = new OperateCatalogClass();
        ArrayList<String> savePath = new ArrayList<String>();
        try {
            File dir = new File("./dir").getCanonicalFile();
            if (dir.exists()) {
                deleteDirectory(dir);
            }
            dir.mkdir();
            savePath.add("<DIR> dir");
            if(dir.listFiles().length == 0) {
                for(int i = 0; i < 4; ++i) {
                    String dirPath = "./dir/"+i;
                    savePath.add("<DIR> "+String.valueOf(i));
                    File inner = new File(dirPath);
                    inner.mkdir();
                    for(int j = 0; j < 2; ++j) {
                        String filePath = "./dir/"+i+"/"+j+".txt";
                        savePath.add(String.valueOf(j)+".txt");
                        File innerFile = new File(filePath);
                        innerFile.createNewFile();
                    }
                }
            }
            String outputPath = "output.txt";
            File outputFile = new File(outputPath).getCanonicalFile();
            if (outputFile.exists()) {
                outputFile.delete();
            }
            outputFile.createNewFile();

            FileOutputClass fOut = new FileOutputClass();
            operateCatalog.displayAll(dir, 0, outputPath, fOut);

            Scanner fileScanner = new Scanner(outputFile);
            ArrayList<String> testData = new ArrayList<>();
            while (fileScanner.hasNextLine()) {
                testData.add(fileScanner.nextLine());
            }
            for (String i : testData) {
                Assertions.assertTrue(savePath.contains(i.trim()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static public boolean deleteDirectory(File path) {
        if (path.exists()) {
            File[] files = path.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    deleteDirectory(files[i]);
                } else {
                    files[i].delete();
                }
            }
        }
        return (path.delete());
    }
}