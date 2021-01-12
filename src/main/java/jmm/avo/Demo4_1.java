package jmm.avo;

import java.util.concurrent.atomic.LongAdder;

public class Demo4_1 {
    static int i = 0;
    static Object obj = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int j = 0; j < 5000; j++) {
                System.out.println("1112222");
                synchronized (obj) {
                    i++;
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int j = 0; j < 5000; j++) {
                System.out.println("aaaabbbb");
                synchronized (obj) {
                    i--;
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
