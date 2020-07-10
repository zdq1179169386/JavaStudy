package com.zdq;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> arrayList = new ArrayList<Person>();
        arrayList.add(new Person(10,"zdq"));
        arrayList.add(new Person(20,"zdq2"));
        arrayList.add(new Person(30,"zdq3"));
        System.out.print(arrayList.toString());


    }

    public static void test() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);
        System.out.println(arrayList.toString());

        arrayList.remove(arrayList.size()-1);

        System.out.println(arrayList.toString());

        arrayList.remove(0);
        System.out.println(arrayList.toString());

        arrayList.remove(0);
        System.out.println(arrayList.toString());

        arrayList.remove(0);
        System.out.println(arrayList.toString());
    }
}
