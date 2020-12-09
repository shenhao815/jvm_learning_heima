package com.it.demo;

/**
 * @author ch
 * @date 2020-12-9
 */
public class Demo1_21 {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "a"+"b";
        String s4 = s1 + s2;// 两个变量的拼接，所以它是在程序运行期间通过StringBuilder来进行字符串的拼接，产生一个新的字符串，这个字符串放在堆里
        String s5 = "ab";
        String s6 = s4.intern();

        // 问
        System.out.println(s3 == s4); // false
        System.out.println(s3 == s5); // true
        System.out.println(s3 == s6); // true

        String x2 = new String("c") + new String("d"); //
        String x1 = "cd";
        x2.intern();

        // 问1
        System.out.println(x1 == x2); // x2.intern()之前串池中已有”cd“,所以不会再将cd放入中池中，所以为false
        // 问2：如果将String x1="cd"在x2.intern()后面执行呢呢
        System.out.println(x1 == x2); // x2.intern()之前串池中没有”cd“,所以将x2的字符串对象放入中池中，所以为true
        // 问3：如果是jdk1.6呢
        System.out.println(x1 == x2);// 在1.6中x2.intern()会将对象复制一份，将复制的对象存入串池中，所以不管顺序如何，都为false
    }
}
