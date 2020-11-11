package com.ontopoff.listDir;

import java.io.File;
import java.io.IOException;

public class DirListClass {

    public static void main(String[] args) throws IOException {
        if(args.length != 2) {
            System.out.println("Аргументы программы переданы неверно!");
            System.out.println("Корректные аргументы: Путь_к_директории Путь_к_целевому_файлу");
            return;
        }
        FileOutputClass fOut = new FileOutputClass();
        fOut.checkFile(args[1]);

        OperateCatalogClass catalog = new OperateCatalogClass();
        File path = new File(args[0]);
        int levelPath = 0;
        catalog.displayAll(path, levelPath, args[1], fOut);
    }
}
