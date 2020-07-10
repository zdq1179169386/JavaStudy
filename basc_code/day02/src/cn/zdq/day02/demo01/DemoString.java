package cn.zdq.day02.demo01;

public class DemoString {
    public static void main(String[] args) {
//        demo3();
//        demo4();
        demo6();
    }

    static void demo(){
        String  a = new String();
        char[] chars = {'a','b','c'};

        String b = new String(chars);
        System.out.println(b);

        byte[] bytes = {97,98,99};
        String c = new String(bytes);
        System.out.println(c);

        String d = "helllo";
    }
    static void demo1() {
        /*
        字符创常量池：双引号中的字符串，就是在字符串常量池中
        * */
        String  str1 = "abc";
        String  str2 = "abc";

        char[] chars = {'a','b','c'};
        String str3 = new String(chars);
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str2 == str3);
        System.out.println("str1:" + System.identityHashCode(str1));
        System.out.println("str2:" + System.identityHashCode(str2));
        System.out.println("str3:" + System.identityHashCode(str3));
    }

    static void demo2() {
        String  str1 = "abc";
        String  str2 = "abc";

        char[] chars = {'a','b','c'};
        String str3 = new String(chars);
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
        System.out.println(str2.equals(str3));

        //区分大小写
        System.out.println("abc".equalsIgnoreCase("ABC"));
    }
    static void demo3() {
        String str1 = "hello ";
        String str2 = "world";
        String str3 = str1.concat(str2);
        String str4 = str1 + str2;
        System.out.println(str3);
        System.out.println(str4);

        //获取单个字符
        char ch = str3.charAt(1);
        System.out.println(ch);

        //获取索引,-1 没有
        int index = str3.indexOf("llo");
        System.out.println(index);
    }
    static  void demo4() {
        //截取
        String str = "Hello World";
        String str1 = str.substring(6,str.length());
        System.out.println(str1);
    }
    static void demo5() {
        //转化为字符数组
        String str1 = "Hello";
        System.out.println(str1.toCharArray());

        //字节数组
        byte[] bytes = "abc".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }

        String str2 = "How do you do";
        String str3 = str2.replace("o","*");
        System.out.println(str3);
    }
    static void demo6() {
        String str = "aaa,bbb,ccc";
        String[] arr = str.split(",");
        for (String a: arr) {
            System.out.println(a);
        }
    }
}
