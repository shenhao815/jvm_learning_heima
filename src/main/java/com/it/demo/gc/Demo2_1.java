package com.it.demo.gc;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Demo2_1 {
    private static final int _512KB = 512 * 1024;
    private static final int _1MB = 1024 * 1024;
    private static final int _6MB = 6 * 1024 * 1024;
    private static final int _7MB = 7 * 1024 * 1024;
    private static final int _8MB = 8 * 1024 * 1024;

    // -Xms20m -Xmx20m -Xmn10m -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc
    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        /*list.add(new byte[_7MB]);
        list.add(new byte[_512KB]);
        list.add(new byte[_512KB]);*/
        //list.add(new byte[_1MB]);
        list.add(new byte[_8MB]);
        list.add(new byte[_7MB]);
        list.add(new byte[_1MB]);
        list.add(new byte[_1MB]);
    }
}
