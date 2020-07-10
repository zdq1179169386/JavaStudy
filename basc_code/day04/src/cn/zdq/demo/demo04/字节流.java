package cn.zdq.demo.demo04;

import java.io.*;

public class 字节流 {
    public static void main(String[] args) {
        try {
            test();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void test() throws IOException {
//       String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
//       String path = ClassLoader.getSystemResource("").toString();
        File file = new File("file:" + File.separator +"a.txt");
        if (!file.exists()){
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        //true 追加数据
        FileOutputStream fos = new FileOutputStream(file,true);
        //换行，通用
        String newLine = System.getProperty("line.separator");
        fos.write("hello world".getBytes());
        fos.write(newLine.getBytes());
        fos.close();

    }
}
