package cn.zdq.demo.demo04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class copyDemo {
    public static void main(String[] args) {
        try {
            test();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //字节流不能读取中文字符
    static void test() throws IOException {
        File file = new File("file:" + File.separator +"a.txt");
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream("file:" + File.separator + "b.txt");
        byte[] bytes = new byte[(int)file.length()];
        fis.read(bytes);
        fos.write(bytes);
        fis.close();
        fos.close();
    }
}
