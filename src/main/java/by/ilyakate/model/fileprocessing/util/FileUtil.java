package by.ilyakate.model.fileprocessing.util;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<File> getFilesForCurrentYear(File directory) {
        List<File> validFiles = new ArrayList<>();
        int currentYear = LocalDate.now().getYear();

        if (directory.exists() && directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                if (file.isFile() && isValidYear(file, currentYear)) {
                    validFiles.add(file);
                }
            }
        }
        return validFiles;
    }

    private static boolean isValidYear(File file, int year) {
        String fileName = file.getName();
        return fileName.contains(String.valueOf(year));
    }
}
