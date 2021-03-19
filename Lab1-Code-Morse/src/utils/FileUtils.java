package utils;

import java.io.*;
import java.nio.file.*;

public class FileUtils {
    private final String filename;
    private final String subPath;

    public FileUtils(String filename) {
        this.filename = filename;
        this.subPath = "data";
    }
    public FileUtils(String filename, String subPath) {
        this.filename = filename;
        this.subPath = subPath;
    }
    public String getAbsoluteFilePath() {
        Path path = Paths.get(System.getProperty("user.dir"), subPath, filename);
        return path.normalize().toString();
    }
    public boolean isFileExists() {
        File file = new File(getAbsoluteFilePath());
        return file.exists();
    }
    public BufferedReader getFileReader() {
        try {
            File f = new File(getAbsoluteFilePath());
            FileReader fr = new FileReader(f);
            return new BufferedReader(fr);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    public PrintStream getFileOutStream() {
        try {
            FileOutputStream fos = new FileOutputStream(getAbsoluteFilePath());
            return new PrintStream(fos);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
