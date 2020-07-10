package cn.zdq.day02.demo01;

import java.util.Arrays;

public class Demo01Arrays {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {2,11,10,6};
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));

        String[] arr3 = {"b","cc","a"};
        Arrays.sort(arr3);
        System.out.println(Arrays.toString(arr3));

        Zi zi = new Zi();

    }
}
