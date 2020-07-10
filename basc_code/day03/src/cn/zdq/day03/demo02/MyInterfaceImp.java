package cn.zdq.day03.demo02;


//实现接口
//如果一个类没有实现接口中的所有抽象方法，那么这个类必须是抽象类，否则报错
public class MyInterfaceImp implements MyInterface {
    @Override
    public void method() {
        System.out.println("实现接口的抽象方法");
    }

}
