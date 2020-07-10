package cn.zdq.demo.demo03;

import java.io.File;
import java.io.FileFilter;
import java.util.List;

public class file {
    public static void main(String[] args) {
        getFile1(new File("/Users/qrh/Documents/书"));
    }
    static void getFile(File dir) {
        File[] files = dir.listFiles();
        for(File file : files) {
            if (file.isDirectory()){
                getFile(file);
            } else {
                System.out.println(file);
            }
        }
    }
    static void getFile1(File dir) {
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory()){
                    return  true;
                }
                return pathname.getName().toLowerCase().endsWith("pdf");
            }
        });
        for(File file : files) {
            if (file.isDirectory()){
                getFile(file);
            } else {
                System.out.println(file);
            }
        }
    }
}
