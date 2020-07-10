package cn.zdq.day03.demo02;

//接口,可以有常量，不能有变量
public interface MyInterface {
    //接口常量使用大写，默认是publick static final 修饰的
    int NUM = 10;

    //接口中的抽象方法，public 和 abstract 可以省略
    void method();

//    void  method1();

    //接口不能有实例方法

    //接口的静态方法
    public static void method2() {
        System.out.println("接口的静态方法");

    }

    //默认方法，不需要子类实现也可调用，子类如果重写了，优先调子类的，,用于接口升级
    public default void methodDefault() {
        System.out.println("接口的默认方法");
    }
    //实例方法只能私有
    private void method3() {
        System.out.println("私有方法");
    }

    private void method5() {
        method2();
        method3();
        method5();
    }

    private static void method4() {
        System.out.println("私有静态方法");
    }


    //接口没有静态代码块，和构造方法
    //一个类的父类是唯一的，接口可以是多个
    //多个接口中有相同的抽象方法，只需要实现一个就行
    //多个接口中相同的默认方法
}
