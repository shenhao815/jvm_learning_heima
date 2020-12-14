package com.it.demo.gc;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 演示弱引用
 * -Xmx20m  设置堆大小为20mb
 * -XX:+PrintGCDetails -verbose:gc  打印垃圾回收详情
 */
public class Demo2_5 {
    private static final int _4MB = 4 * 1024 * 1024;

    public static void main(String[] args) {
        List<WeakReference<byte[]>> list = new ArrayList<>();

        // 注意循环5次、6次和10的区别
        for (int i = 0; i < 5; i++) {
            WeakReference<byte[]> ref = new WeakReference<>(new byte[_4MB]);
            list.add(ref);
            for (WeakReference<byte[]> w : list) {
                System.out.print(w.get()+" ");
            }
            System.out.println();
        }
        System.out.println("循环结束："+list.size());
    }
}
