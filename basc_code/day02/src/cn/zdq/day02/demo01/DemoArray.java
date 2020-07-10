package cn.zdq.day02.demo01;

import java.util.ArrayList;

public class DemoArray {
    public static void main(String[] args) {
        //数组
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        //java 数组不能装基本类型，必须转化为包装类,首字母大写
//        int Integer
//        Boolean
//        Byte
//        Short
//        Long
//        Character
//        Float
//        Double
    }
}
