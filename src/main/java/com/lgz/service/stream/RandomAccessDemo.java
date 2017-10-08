package com.lgz.service.stream;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by GAVIN on 2017/10/7.
 */
public class RandomAccessDemo {
    /**
     * 随机写入的文件打不开
     * */
    public static void main(String[] args) throws IOException {
        String folder = Util.getFolder();
        RandomAccessFile reader = new RandomAccessFile(DataSource.IMAGE, "r");
        RandomAccessFile writer = new RandomAccessFile(folder + "temp.png", "rw");

        long fileLength = reader.length();
        // 读文件的起始位置
        int beginIndex = (fileLength > 4) ? 4 : 0;
        // 将读文件的开始位置移到beginIndex位置。
        reader.seek(beginIndex);
        byte[] bytes = new byte[10000];
        int byteread = 0;
        // 一次读10个字节，如果文件内容不足10个字节，则读剩下的字节。
        // 将一次读取的字节数赋给byteread
        while ((byteread = reader.read(bytes)) != -1) {
            System.out.println("Reading: " + byteread);
            writer.write(bytes);
        }
    }
}
