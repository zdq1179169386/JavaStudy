package cn.zdq.day03.demo01;

//继承抽象类，实现抽象方法
public class Cat extends Animal{

    public Cat() {
    }

    public Cat(int age, String name) {
        super(age, name);
    }

    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}
