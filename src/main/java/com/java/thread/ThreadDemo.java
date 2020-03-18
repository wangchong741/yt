package com.java.thread;


import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo {
    public static void main(String[] args) {
//        test();
//        test2();
//        test3();
//        runDAfaterABC();
        test4();
    }

    /**
     * 用FutureTask和Callable可以在主线程获取子线程的运行结果，只不过要阻塞主线程
     * 如果不希望阻塞，可以开率用ExecutorService，把FutureTask放到线程池
     */
    public static void test4(){
        Callable<Integer> callable= () -> {
            System.out.println("子线程开始");
            Thread.sleep(100);
            int result=0;
            for (int i = 0; i <= 100; i++) {
                result+=i;
            }
            System.out.println("结束");
            return result;
        };
        FutureTask<Integer> futureTask=new FutureTask<>(callable);
        new Thread(futureTask).start();
        try {
            System.out.println("拿结果前");
            System.out.println(futureTask.get());
            System.out.println("拿结果后");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * 四个线程ABCD，D要等ABC全执行完在执行，而ABC是同步执行
     */
    public static void runDAfaterABC(){
        int worker = 3;
        CountDownLatch countDownLatch=new CountDownLatch(worker);
        new Thread(()->{
            System.out.println(" D 在等待ABC执行完");
            try {
                countDownLatch.await();
                System.out.println("ABC已执行完，D开始");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        for (char threadName='A';threadName <='C';threadName++){
            final String tN=String.valueOf(threadName);
            new Thread(()->{
                System.out.println(tN+"正在执行");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(tN+"执行完成");
                countDownLatch.countDown();
            }).start();
        }
    }


    /**
     * 两个线程按照指定方式有序交叉执行
     * A 1  B 123 A 23
     */
    public static void test3(){
        // 先创建一个AB共享的对象锁 lock=new Object();
        // 当A拿到锁之后，先打印1，然后调用lock.wait()方法，交出锁的控制权，进入wait状态
        // 对B而言，由于A先获得到锁，导致B无法执行，知道A调用lock.wait()方法释放控制权，B才得到了锁
        // B在得到锁之后，打印123，调用lock.notify()方法，唤醒正在等待的A
        Object lock=new Object();
        Thread A=new Thread(()->{
            synchronized (lock){
                System.out.println("A 1");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A 2");
                System.out.println("A 3");
            }
        });
        Thread B=new Thread(()->{
            synchronized (lock){
                System.out.println("B 1");
                System.out.println("B 2");
                System.out.println("B 3");
                lock.notify();
            }
        });
        A.start();
        B.start();
    }

    /**
     * 希望B在A执行完之后执行
     */
    public static void test2() {
        Thread A=new Thread(() -> printNumber("A"));
        Thread B=new Thread(() -> {
            System.out.println("等待A执行完");
            try {
                A.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            printNumber("B");
        });
        A.start();
        B.start();
    }

    /**
     * AB 同时打印
     */
    public static void test() {
        new Thread(() -> printNumber("A")).start();
        new Thread(() -> printNumber("B")).start();
    }

    private static void printNumber(String threadName) {
        int i = 0;
        while (i++ < 3) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + "print : " + i);
        }
    }
}
