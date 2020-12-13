package com.it.demo.gc;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 演示软引用
 * -Xmx20m 设置堆内存20m
 * -XX:+PrintGCDetails -verbose:gc 打印垃圾回收详细信息
 */
public class Demo2_3 {
    private static final int _4MB = 4 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
        //strongReference();
        softReference();
    }

    /**
     * 强引用
     * 通过new关键字创建集合，并用“=”赋值给list，又通过new创建byte数组，
     * 此案例都是用的强引用
     * 如果堆内存为20m，运行此代码会报 java.lang.OutOfMemoryError: Java heap space
     * @throws IOException
     */
    private static void strongReference() throws IOException {
        List<byte[]> list = new ArrayList<byte[]>();
        for (int i = 0; i <5; i++) {
            list.add(new byte[_4MB]);
        }
        System.in.read();
    }

    /**
     * 软引用
     */
    private static void softReference() {
        // list --> SoftReference --> byte[]
        List<SoftReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SoftReference<byte[]> ref = new SoftReference<>(new byte[_4MB]);
            System.out.println(ref.get());
            list.add(ref);
            System.out.println(list.size());
        }
        System.out.println("循环结束：" + list.size());
        for (SoftReference<byte[]> ref : list) {
            System.out.println(ref.get());
        }

    }
}
