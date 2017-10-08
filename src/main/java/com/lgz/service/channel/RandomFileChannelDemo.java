package com.lgz.service.channel;

import com.lgz.service.stream.DataSource;
import com.lgz.service.stream.Util;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by GAVIN on 2017/10/8.
 */
public class RandomFileChannelDemo {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        File sourceFile = new File(DataSource.IMAGE);
        File desFile = new File(Util.getFolder() + "2" + sourceFile.getName());

        FileChannel witeChannel = new RandomAccessFile(desFile, "rw").getChannel();
        FileChannel readChannel = new RandomAccessFile(sourceFile, "r").getChannel();
        ByteBuffer readBuffer = ByteBuffer.allocate(BSIZE);

        while (readChannel.read(readBuffer) != -1) {
            readBuffer.flip();
            witeChannel.write(readBuffer);
            System.out.println("Reading ... : " + readBuffer.capacity());
            readBuffer.clear();
        }
    }
}
