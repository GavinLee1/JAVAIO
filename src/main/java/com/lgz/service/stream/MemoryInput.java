package com.lgz.service.stream;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by GAVIN on 2017/10/7.
 */
public class MemoryInput {
    public static void main(String [] args) throws IOException{
        StringReader in = new StringReader(
                BufferedInputFile.read("/Users/GAVIN/Documents/MySPACE/LOOPS/login/src/main/java/com/loops/login/config/AwsConfig.java"));
        int c;

        while ((c = in.read()) != -1) {
            System.out.print((char)c);
        }
    }
}
