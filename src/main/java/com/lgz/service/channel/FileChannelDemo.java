package com.lgz.service.channel;

import com.lgz.service.stream.DataSource;
import com.lgz.service.stream.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by GAVIN on 2017/10/8.
 */
public class FileChannelDemo {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        File sourceFile = new File(DataSource.IMAGE);
        File desFile = new File(Util.getFolder() + sourceFile.getName());

        FileChannel witeChannel = new FileOutputStream(desFile).getChannel();
        FileChannel readChannel = new FileInputStream(sourceFile).getChannel();
        ByteBuffer readBuffer = ByteBuffer.allocate(BSIZE);

        while (readChannel.read(readBuffer) != -1) {
            readBuffer.flip();
            witeChannel.write(readBuffer);
            System.out.println("Reading ... : " + readBuffer.capacity());
            readBuffer.clear();
        }
    }
}
