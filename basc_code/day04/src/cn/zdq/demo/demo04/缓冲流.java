package cn.zdq.demo.demo04;

import java.io.*;

public class 缓冲流 {
    public static void main(String[] args) {
        try {
            test3();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void test() throws IOException {
        //字节输出缓冲流
        FileOutputStream fos = new FileOutputStream("file:" + File.separator + "b.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write("缓冲流".getBytes());
        bos.flush();
        bos.close();
    }

    static void test1() throws IOException {
        //字节输入缓冲流
        FileInputStream fis = new FileInputStream("file:" + File.separator + "a.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        int len = 0;
        byte[] bytes = new byte[10];
        while ((len = bis.read(bytes))!= -1){
            System.out.println(new String(bytes));
        }
        bis.close();
    }

    static void test2() throws IOException {
        //字符缓冲输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("file:" + File.separator + "a.txt"));
        bw.write("字符输出缓冲流");
        bw.flush();
        bw.close();
    }
    static void test3() throws IOException {
        //字符缓冲输入流
        BufferedReader br = new BufferedReader(new FileReader("file:" + File.separator + "b.txt"));
        String line = null;
        while ((line = br.readLine())!= null){
            System.out.println(line);
        }
        br.close();
    }

}
