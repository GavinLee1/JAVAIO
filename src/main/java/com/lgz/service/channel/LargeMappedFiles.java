package com.lgz.service.channel;

import com.lgz.service.stream.DataSource;
import com.lgz.service.stream.Util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by GAVIN on 2017/10/8.
 */
public class LargeMappedFiles {
    public static void main(String[] args) throws IOException {
        File sourceFile = new File(DataSource.IMAGE);
        File desFile = new File(Util.getFolder() + "mapped-" + sourceFile.getName());

        long length = sourceFile.length();
        MappedByteBuffer in = new RandomAccessFile(sourceFile, "r").getChannel()
                .map(FileChannel.MapMode.READ_ONLY, 0, length);

        MappedByteBuffer out = new RandomAccessFile(desFile, "rw").getChannel()
                .map(FileChannel.MapMode.READ_WRITE, 0, length);

        while (in.hasRemaining()) {
            out.put(in.get());
        }
    }
}
