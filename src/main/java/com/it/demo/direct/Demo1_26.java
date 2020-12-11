package com.it.demo.direct;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * 直接内存  释放原理演示
 *
 * @author ch
 * @date 2020-12-11
 */
public class Demo1_26 {
    static int _1Gb = 1024*1024*1024;

    /**
     * -XX:+DisableExplicitGC 禁用显式的垃圾回收（即让代码中的System.gc()失效）
     */
    public static void main(String[] args) throws IOException {
        System.out.println("程序运行...");
        System.in.read();
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1Gb);
        System.out.println("分配完毕...");
        System.in.read();
        System.out.println("开始释放...");
        byteBuffer = null;
        System.gc(); // 显式的垃圾回收，Full GC
        System.in.read();
    }
}
