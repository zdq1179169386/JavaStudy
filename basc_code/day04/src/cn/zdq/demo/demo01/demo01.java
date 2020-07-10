package cn.zdq.demo.demo01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class demo01 {
    //数组结构
    /*
    栈，先进后出
    队列先进先出
    * */
    // HashSet 存储自定义类型必须重写 equals 和 hashCode 方法，才能实现不存储相同元素
    public static void main(String[] args) {
//       test();
        sort();
    }

    public static void test() {
        HashSet<Person> set = new HashSet<>();
        Person person1 = new Person("zdq", 10);
        Person person2 = new Person("zdq", 10);
        Person person3 = new Person("zdq3", 12);
        set.add(person1);
        set.add(person2);
        set.add(person3);
        System.out.println(set);
    }

    private static void sort() {
        /*
        Comparable 和 Comparator 都可以实习排序
        * */
        ArrayList<Person> list = new ArrayList<>();
        Person p1 = new Person("zdq", 10);
        Person p2 = new Person("zdq2", 12);
        Person p3 = new Person("zdq3", 11);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        System.out.println(list);
    }
}
