package com.it.demo.load;

public class Load9 {
    public static void main(String[] args) {
        Singleton.getInstance();
    }
}

class Singleton {
    private Singleton(){}

    public static void test() {
        System.out.println("sf");
    }

    private static class LazyHolder {
        private static final Singleton INSTANCE = new Singleton();
        static {
            System.out.println("lazy holder init");
        }
    }

    public static Singleton getInstance() {
        return LazyHolder.INSTANCE;
    }

}
