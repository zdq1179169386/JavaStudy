package cn.zdq.day02.demo01;

import java.util.Random;

public class DemoRandom {
    public static void main(String[] args) {
        //随机数
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int a = random.nextInt(10);//0 - 9
            System.out.println(a);
        }

        Random random = new Random();
        int b = random.nextInt(51) + 100; // 100 - 150
    }
}
