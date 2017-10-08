package com.lgz.service.stream;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by GAVIN on 2017/10/7.
 */
public class FormattedMemoryInput {
    public static void main(String [] args) throws IOException{
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(
                BufferedInputFile.read("/Users/GAVIN/Documents/MySPACE/LOOPS/login/src/main/java/com/loops/login/config/AwsConfig.java")
                        .getBytes()));
        while (in.available() != 0) {
            System.out.print((char)in.readByte());
        }
    }
}
