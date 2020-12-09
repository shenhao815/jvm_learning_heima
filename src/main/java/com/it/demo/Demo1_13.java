package com.it.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用jvisualvm工具演示查看对象个数 堆转储(dump)
 *
 * @author ch
 * @date 2020-12-9
 */
public class Demo1_13 {
    public static void main(String[] args) throws InterruptedException {
        List<Student> students = new ArrayList<Student>();
        for (int i = 0; i < 200; i++) {
            students.add(new Student());
        }
        Thread.sleep(10000000L);
    }
}
class Student{
    private byte[] big = new byte[1024 * 1024];
}