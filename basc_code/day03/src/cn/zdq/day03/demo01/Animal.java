package cn.zdq.day03.demo01;

//抽象类,不能实例化，可以有成员变量，成员方法，构造方法
public abstract class Animal {
    int age;

    String name;

    public Animal() {

    }

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    //抽象方法
    public abstract void eat();
    //实例方法
    public void log(){

    }
}
