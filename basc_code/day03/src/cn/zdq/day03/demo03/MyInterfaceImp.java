package cn.zdq.day03.demo03;

public class MyInterfaceImp implements MyInterfaceA, MyInterfaceB {
    @Override
    public void methodA() {
        System.out.println("实现methodA 方法");
    }

    @Override
    public void methodB() {
        System.out.println("实现methodB 方法");
    }

    @Override
    public void sameMethod() {
        System.out.println("接口中相同抽象方法只需要实现一个");
    }

    @Override
    public void sameDefaultMethod() {

    }

    //接口没有静态代码块，和构造方法
    //一个类的父类是唯一的，接口可以是多个
    //多个接口中有相同的抽象方法，只需要实现一个就行
    //多个接口中相同的默认方法,也需要重写
    //一个类的父类中的实例方法，和接口中的默认方法，相同，优先调用父类的实例方法
    //接口和接口之间是多继承
}
