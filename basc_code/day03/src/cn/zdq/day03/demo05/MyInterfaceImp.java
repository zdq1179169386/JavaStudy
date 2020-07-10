package cn.zdq.day03.demo05;

//限制了类的泛型
public class MyInterfaceImp<T> implements MyInterface<T> {

    @Override
    public void method(T o) {
         System.out.println("实现带有泛型的接口方法");
    }
}
