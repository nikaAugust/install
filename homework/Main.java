package homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();
        File tempFile = new File("D:\\Games\\temp", "temp.txt");

        File[] dirs = new File[]{
                new File("D:\\Games\\src\\"),
                new File("D:\\Games\\res"),
                new File("D:\\Games\\savegames"),
                new File("D:\\Games\\temp"),
                new File("D:\\Games\\src\\main"),
                new File("D:\\Games\\src\\test"),
                new File("D:\\Games\\res\\drawables"),
                new File("D:\\Games\\res\\vectors"),
                new File("D:\\Games\\res\\icons")
        };

        File[] files = new File[]{
                new File("D:\\Games\\src\\main", "Main.java"),
                new File("D:\\Games\\src\\main", "Utils.java"),
                tempFile
        };

        for (File dir : dirs) {
            log.append(dirCreated(dir));
        }

        for (File file : files) {
            log.append(fileCreated(file));
        }

        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write(log.toString());
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static String dirCreated(File dir) {
        if (dir.mkdir()) {
            return "Каталог " + dir.getPath() + " создан.\n";
        } else {
            return "Не создан каталог " + dir.getPath() + ".\n";
        }
    }

    public static String fileCreated(File file) {
        try {
            if (file.createNewFile()) {
                return "Файл " + file.getName() + " создан.\n";
            } else {
                return "Не удалось создать файл " + file.getName() + ".\n";
            }
        } catch (IOException exception) {
            return "Не создан файл " + file.getName() + "\n";
        }
    }
}
