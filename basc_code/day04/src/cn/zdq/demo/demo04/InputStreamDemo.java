package cn.zdq.demo.demo04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStreamDemo {
    public static void main(String[] args) {
        try {
            test1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //字节输入流
    static void test() throws IOException {
        File file = new File("file:" + File.separator +"a.txt");
        FileInputStream fis = new FileInputStream(file);
        int length = 0;
        while ((length = fis.read()) != -1) {
            System.out.print((char) length);
        }
        fis.close();
    }

    static void test1() throws IOException {
        File file = new File("file:" + File.separator +"a.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = new byte[(int)file.length()];
        fis.read(bytes);
        System.out.println(new String(bytes));
        fis.close();
    }
}
