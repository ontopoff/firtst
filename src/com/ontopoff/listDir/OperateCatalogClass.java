package com.ontopoff.listDir;

import java.io.File;
import java.io.IOException;

public class OperateCatalogClass {

    public void displayAll(File path, int levelPath ,String outputPath, FileOutputClass fOut) throws IOException {
        try {
            if (path.isFile()) {
                for (int i = 0; i < levelPath; ++i) {
                    fOut.writeToFile(outputPath, "\t");
                }
                fOut.writeToFile(outputPath, path.getName() + "\n");
            } else {
                for (int i = 0; i < levelPath; ++i) {
                    fOut.writeToFile(outputPath, "\t");
                }
                levelPath++;
                fOut.writeToFile(outputPath, "<DIR> ");
                fOut.writeToFile(outputPath, path.getName() + "\n");
                File files[] = path.listFiles();
                for (File dirOrFile : files) {
                    displayAll(dirOrFile, levelPath, outputPath, fOut);
                }
                levelPath--;
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("Указанная директория/файл не найдена!");
        }
    }
}
