package com.zdq;

public class Main {
    public static void main(String[] args) {
        test1();
    }

    static void test(){
        int code = Float.floatToRawIntBits(10.6f);
        System.out.println(code);
        System.out.println(Integer.toBinaryString(code));
        String str = "jack";
        System.out.println(str.hashCode());
    }

    static void test1() {
        Integer a = 1;
        Float b = 1.2f;
        Long c = 10l;
        Double d = 10.9;
        String e = "jack";

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
        System.out.println(d.hashCode());
        System.out.println(e.hashCode());
    }
}
