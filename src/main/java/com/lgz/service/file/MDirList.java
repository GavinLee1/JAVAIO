package com.lgz.service.file;

import java.io.File;
import java.util.Arrays;

/**
 * Created by GAVIN on 2017/10/7.
 */
public class MDirList {
    /**
     * 过滤文件名 的普通实现
     */
    public static void main(String[] args) {
        String regex = "(\\w)*\\.java";

        File path = new File("/Users/GAVIN/Documents/MySPACE/LOOPS/login/src/main/java/com/loops/login/config/");

        String[] list = path.list(new DirFilter(regex));

//        if(args.length == 0) {
//            list = path.list();
//        } else {
//            list = path.list(new DirFilter(args[0]));
//        }

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);

        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}
