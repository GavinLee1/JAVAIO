package com.lgz.service.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by GAVIN on 2017/10/7.
 */
public class MDirList2 {
    /**
     * 内部类 实现过多文件名
     */

    public static FilenameFilter filter(final String regex) {
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }

    public static void main(String[] args) {
        String regex = "(\\w)*\\.java";
        File path = new File("/Users/GAVIN/Documents/MySPACE/LOOPS/login/src/main/java/com/loops/login/config/");
        String[] list = path.list(filter(regex));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);

        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}
