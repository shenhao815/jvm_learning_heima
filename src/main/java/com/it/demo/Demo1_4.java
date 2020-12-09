package com.it.demo;

/**
 * 堆内存大小监控演示
 *
 * @author ch
 * @date 2020-12-9
 */
public class Demo1_4 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("1.....");
        Thread.sleep(30000);
        byte[] array = new byte[1024 * 1024 * 10]; // 10mb
        System.out.println("2......");
        Thread.sleep(30000);
        array = null;
        System.gc();
        System.out.println("3......");
        Thread.sleep(10000000L);
    }
}
