package com.lgz.service.stream;

import com.sun.javafx.binding.StringFormatter;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by GAVIN on 2017/10/7.
 */
public class BasicFileOutput {


    public static void main(String [] args) throws IOException {
        String rootFileFolder = "/Users/Gavin/Documents/TMP/";
        String dailyFolderName = LocalDate.now().toString();
        String hourlyFolderName = String.valueOf(LocalDateTime.now().getHour());
        String fileFolder = String.format("%s%s/%s/", rootFileFolder, dailyFolderName, hourlyFolderName);

        String fileName = "BasicOutput.out";

        File file = new File(fileFolder);
        boolean dirExist = file.exists();
        if(!file.exists()) {
            dirExist = file.mkdirs();
        }

        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(DataSource.ROOT_FILE)));

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileFolder + fileName)));
        // new PrintWriter(fileFolder + fileName));

        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }
        out.close();

        System.out.println(BufferedInputFile.read(fileFolder + fileName));
    }
}
