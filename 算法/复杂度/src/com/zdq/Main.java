package com.zdq;

//菲波那切数列
public class Main {
    public static void main(String[] args) {
//        System.out.println(fib(30));
//        System.out.println(fib2(64));

        int n = 50;

        Times.test("fib2", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(fib2(n));
            }
        });

        Times.test("fib", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(fib(n));
            }
        });



    }

    public static int fib(int n) {
        if (n <= 1) return  n;
        return fib(n - 1) + fib(n-2);
    }

    public static int fib2(int n) {
        if (n<=1) return n;
        int first = 0;
        int second = 1;
        for (int i = 0; i < n-1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }
}
/*
大O 表示法
* */