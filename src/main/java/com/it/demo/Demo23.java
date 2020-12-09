package com.it.demo;

/**
 * @author ch
 * @date 2020-12-9
 */
public class Demo23 {

    // StringTable [ "a","b","ab" ]
    public static void main(String[] args) {
        String s = new String("a") + new String("b"); // new String()创建出来的对象都在堆中，此时s也在堆中

        // 此时串池中还没有”ab“,
        // 现将s这个字符串对象尝试放入串池，如果有则不会放入，如果没有测放入池中，会所串池中的对象返回
        // 此时s对象指向串池中的“ab“。此时 s == "ab"为true
        // 但是，如果执行此行代码之前串池中已存在”ab“,那么s这个字符串对象放入池中失败，s也就不会指向串池中的”ab“,
        // 此时 s == "ab" 为false
        String s2 = s.intern();

        System.out.println(s2 == "ab"); // true
        System.out.println(s == "ab"); // true或false取决于s.intern()方法执行前串池中有没有”ab“,如果有”ab“,为false,如果没有，为true

    }
}
