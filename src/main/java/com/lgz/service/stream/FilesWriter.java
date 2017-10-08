package com.lgz.service.stream;

import java.io.*;

/**
 * Created by GAVIN on 2017/10/7.
 */
public class FilesWriter {
    /**
     * InputStream OutputStream
     * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
     */

    /**
     * Reader Writer
     * 以字符为单位读取文件，常用于读文本，数字等类型的文件
     */

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */

    /**
     * 随机读取文件内容
     */

    public static void main(String[] args) throws IOException {
        String folder = Util.getFolder();
        File file = new File("/Users/GAVIN/Downloads/鲛珠传.HD.720p.国语中字.mkv");
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(new File(folder + file.getName())));
        byte [] data = new byte[10000];
        int bytesRead = 0;
        while((bytesRead = reader.read(data)) != -1) {
            System.out.println("Reading... : " + bytesRead);
            writer.write(data);
        }
    }
}
