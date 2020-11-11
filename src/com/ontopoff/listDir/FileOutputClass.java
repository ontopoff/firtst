package com.ontopoff.listDir;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileOutputClass {

    public void checkFile(String path) throws IOException {
        try(FileOutputStream fout = new FileOutputStream(path)) {
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Невозможно открыть файл вывода!");
        }
    }

    public void writeToFile(String outputPath, String pathName) throws IOException {
        try {
            Files.write(Paths.get(outputPath), pathName.getBytes(), StandardOpenOption.APPEND);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
