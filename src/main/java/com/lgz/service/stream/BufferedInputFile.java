package com.lgz.service.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by GAVIN on 2017/10/7.
 */
public class BufferedInputFile {
    public static String read(String fileName) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(fileName));

        String s;
        StringBuilder sb = new StringBuilder();

        while ((s = in.readLine()) != null) {
            sb.append(s + "\n");
        }
        in.close();
        return sb.toString();
    }

    public static void main(String [] args) throws IOException{
        System.out.println(read("/Users/GAVIN/Documents/MySPACE/LOOPS/login/src/main/java/com/loops/login/config/AwsConfig.java"));
    }
}
