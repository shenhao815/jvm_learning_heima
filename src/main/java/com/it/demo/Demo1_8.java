package com.it.demo;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * 演示无空间内存溢出
 * -XX:MaxMetaspaceSize=8m

 * @author ch
 * @date 2020-12-9
 */
public class Demo1_8 extends ClassLoader{
    public static void main(String[] args) {
        int j = 0;
        try{
            Demo1_8 test = new Demo1_8();
            for (int i = 0; i < 200000; i++,j++) {
                // ClassWriter 作用是生成烦的二进制字节码
                ClassWriter cw = new ClassWriter(0);
                // 参数：jdk版本号，public,类名，包名，父类，接口
                cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
                // 返回 byte[]
                byte[] code = cw.toByteArray();
                // 执行了类的加载
                test.defineClass("Class" + i, code, 0, code.length);// Class 对象
            }
        }finally{
            System.out.println(j);
        }
    }
}
