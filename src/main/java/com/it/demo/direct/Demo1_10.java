package com.it.demo.direct;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * 演示直接内存溢出
 *
 * @author ch
 * @date 2020-12-11
 */
public class Demo1_10 {
    static final int _100MB = 1024 * 1024 * 100;

    public static void main(String[] args) {
        List<ByteBuffer> list = new ArrayList<>();
        int i = 0;
        try {
            while (true) {
                ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_100MB);
                list.add(byteBuffer);
                i++;
            }
        } finally {
            System.out.println(i);
        }
    }
}
