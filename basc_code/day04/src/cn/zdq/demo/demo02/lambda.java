package cn.zdq.demo.demo02;

import cn.zdq.demo.demo01.Person;

import java.util.ArrayList;
import java.util.Comparator;

public class lambda {
    public static void main(String[] args) {
//        lambda 表达式
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("zdq",10));
        list.add(new Person("zdq2",13));
        list.add(new Person("zdq3",12));
        list.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });
        System.out.println(list);

        list.sort((Person p1,Person p2) -> {
            return p1.name.compareTo(p2.name);
        });
        System.out.println(list);
    }
}
