package cn.zdq.demo.demo01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.Provider;

public class ServerDemo {
    public static void main(String[] args) {
        try {
            server();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        File file = new File("server:");
        if (!file.exists()){
            file.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream(file  + File.separator+ "1.png");
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = is.read(bytes)) != -1){
            fos.write(bytes,0, len);
        }
        socket.getOutputStream().write("上传成功".getBytes());
        fos.flush();
        fos.close();
        socket.close();
        serverSocket.close();
    }
}
