package cn.zdq.day02.demo01;

public class Person {


    static {
        //静态代码块
        System.out.println("第一次用到这个类的，有点像oc 的 initialize 方法");
    }

    public Person() {
        System.out.println("初始化");
    }
}
