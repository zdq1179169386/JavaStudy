package cn.zdq.day03.demo05;

import java.util.ArrayList;

public class Demo05Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);

        ArrayList<String> arr2 = new ArrayList<>();
        arr2.add("a");
        arr2.add("b");
        arr2.add("c");

        print(arr1);
        print(arr2);
    }

    //泛型通配符
    public static void print(ArrayList<?> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
