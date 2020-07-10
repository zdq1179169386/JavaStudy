package cn.zdq.demo.demo02;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class 异常 {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        {
            try {
                date = sdf.parse("1999-12-09");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        System.out.println(date);

        try {
            readFile("a");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            //一定会执行的代码,避免写return 语句
        }
    }

    public static void readFile(String filePath) throws FileNotFoundException {
        if (!filePath.equals("c://a.txt")){
            throw new FileNotFoundException("文件路径不对");
        }
    }

}
