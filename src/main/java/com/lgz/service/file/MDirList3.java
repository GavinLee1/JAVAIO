package com.lgz.service.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by GAVIN on 2017/10/7.
 */
public class MDirList3 {
    /**
     * 匿名内部类实现 过滤文件名
     */

    public static void main(String[] args) {
        final String regex = "(\\w)*\\.java";
        final File path = new File("/Users/GAVIN/Documents/MySPACE/LOOPS/login/src/main/java/com/loops/login/config/");

        String[] list = path.list(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);

        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}
