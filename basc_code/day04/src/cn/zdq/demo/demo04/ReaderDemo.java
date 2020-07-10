package cn.zdq.demo.demo04;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderDemo {
    public static void main(String[] args) {
        //字符流
        try {
            test1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void test() throws IOException {
        //读
        File file = new File("file:" + File.separator +"a.txt");
        FileReader reader = new FileReader(file);
        int len = 0;
//        while ((len = reader.read()) != -1){
//            System.out.println((char)len);
//        }
        char[] chars = new char[10];
        while ((len = reader.read(chars)) != -1){
            System.out.println(new String(chars));
        }
        reader.close();
    }

    static void test1() throws IOException {
        //写
        File file = new File("file:" + File.separator +"c.txt");
        FileWriter writer = new FileWriter(file);
        char[] cs = {'a','b','c'};
        writer.write(cs);
        writer.write("--zdq");
        //刷新缓冲区
        writer.flush();
        writer.close();
    }
}
