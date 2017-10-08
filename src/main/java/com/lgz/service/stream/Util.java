package com.lgz.service.stream;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by GAVIN on 2017/10/7.
 */
public class Util {
    public static String getFolder() {
        return returnOrCreateFolder(createFolderName());
    }

    public static String returnOrCreateFolder(String folderName) {
        File file = new File(folderName);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.exists() ? folderName : null;
    }

    public static String createFolderName() {
        String rootFileFolder = "/Users/Gavin/Documents/TMP/";
        String dailyFolderName = LocalDate.now().toString();
        String hourlyFolderName = String.valueOf(LocalDateTime.now().getHour());
        String fileFolder = String.format("%s%s/%s/", rootFileFolder, dailyFolderName, hourlyFolderName);

        return fileFolder;
    }
}
