package com.lgz.service.file;

import com.lgz.service.stream.DataSource;

import java.io.File;

import static com.lgz.service.stream.DataSource.ROOT_FILE;

/**
 * Created by GAVIN on 2017/10/8.
 */
public class MFileAttributes {
    public static void main(String[] args) {
        File file = new File(ROOT_FILE);

        System.out.println("getAbsolutePath : "+ file.getAbsolutePath());

        System.out.println("canRead : "+ file.canRead());

        System.out.println("canWrite : "+ file.canWrite());

        System.out.println("getName : "+ file.getName());

        System.out.println("getParent : "+ file.getParent());

        System.out.println("length : "+ file.length());

        System.out.println("lastModified : "+ file.lastModified());
    }
}
