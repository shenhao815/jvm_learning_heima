package com.it.demo.load;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;

public class Load7 {
    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader loader = new MyClassLoader();
        Class<?> c1 = loader.loadClass("HelloWorld");
        /*Class<?> c2 = loader.loadClass("com\\.it\\.demo\\.Student");
        System.out.println(c1 == c2);
        System.out.println(c1.getName());
*/
        MyClassLoader loader2 = new MyClassLoader();
        Class<?> c3 = loader2.loadClass("com.it.demo.Student");
        System.out.println(c1 == c3);
        Class<?> helloWorld = Class.forName("HelloWorld", true, loader2);
        //Object o = helloWorld.newInstance();

    }
}

class MyClassLoader extends ClassLoader {

    /**
     * @param name 类名字
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        name = name.replaceAll("\\.", Matcher.quoteReplacement(File.separator));
        String path = "E:"+File.separator+"myclasspath"+File.separator+ name + ".class";

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            Files.copy(Paths.get(path), os);
            // 得到字节数组
            byte[] bytes = os.toByteArray();
            // byte[] -> *.class
            return defineClass(name, bytes,0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ClassNotFoundException("类文件未找到", e);
        }
    }
}
