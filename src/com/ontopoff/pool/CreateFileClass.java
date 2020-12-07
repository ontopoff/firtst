package com.ontopoff.pool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class CreateFileClass extends ObjectFactory<FileWriter> {

    AtomicInteger currentLogFileId = new AtomicInteger(0);

    @Override
    public FileWriter createObject() {

        String fileLogPath = System.getProperty("user.dir") + File.separator + "Log";
        File logDir = new File(fileLogPath);
        if (!logDir.exists()) {
            logDir.mkdir();
        }
        String logFilePath = fileLogPath + File.separator + currentLogFileId.getAndIncrement()+".txt";
        File logFile = new File(logFilePath);
        try {
            return new FileWriter(logFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
