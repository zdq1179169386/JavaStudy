package cn.zdq.demo.demo02;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class 线程 {
    public static void main(String[] args) {
        test1();;
    }
    static void test() {
        //继承Thread 或者实现Runable 接口
        //匿名内部类
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread.start();
    }
    static void test1() {
//        线程通信
        Object obj = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    System.out.println("告诉老板要买包子");
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //唤醒之后
                    System.out.println("包子做好了，开始吃包子");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj) {
                    System.out.println("花5秒，做包子");
                    obj.notify();
                }
            }
        }).start();
    }
    static void test2() {
        /*
        * newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
*/
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i);
                }
            }
        });
    }
    static void test3() {
        new Thread(() -> {
            System.out.println("lambda 表达式");
        }).start();;
    }
}
