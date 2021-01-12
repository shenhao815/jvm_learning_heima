package com.it.demo.bytecode;

public class Test1 {
    public static void main(String[] args) {
        //System.out.println("hello world");
        /*int a = 10;
        int c = 0;
        int b = a++ + ++a + a-- + a;
        System.out.println(b);*/


        int i = 0;
        int x = 0;
        while (i < 10) {
            x = x++;
            i++;
        }
        System.out.println(x);
    }
}
