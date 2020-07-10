package cn.zdq.demo.demo01;

import java.io.*;
import java.net.Socket;

public class SocketDemo {
    public static void main(String[] args) {
        try {
            client();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    在一个方法或类的开头，输入/**，然后按回车
    * */
    static void client() throws IOException {
        File file = new File("file:" + File.separator + "1.png");
        FileInputStream fis = new FileInputStream(file);
        Socket socket = new Socket("127.0.0.1",8888);
        OutputStream os = socket.getOutputStream();
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes))!= -1){
            //写到服务器
            os.write(bytes,0,len);
        }
        socket.shutdownOutput();

        InputStream is = socket.getInputStream();
        while ((len = is.read(bytes))!= -1){
            System.out.println(new String(bytes));
        }
        fis.close();
        socket.close();;
    }
}
