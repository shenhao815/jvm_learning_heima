package com.it.demo;

/**
 * @author ch
 * @date 2020-12-9
 */
// StringTable [ "a", "b", "ab" ] StringTable为hashtable结构，不能扩容
public class Demo1_22 {

    // 常量池中的信息，都会被加载到运行时常量池中，这是 a b ab 都是常量池中的符号，还没有变为java字符串对象
    // ldc #2 会把 a 符号变为 “a” 字符串对象
    // ldc #3 会把 b 符号变为 “b” 字符串对象
    // ldc #4 会把 ab 符号变为 “ab” 字符串对象
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2; // new StringBuilder().append("a").append("b").toString()  new String("ab") 此时s4在堆中，与串池中的“ab”不是一回事
        String s5 = "a" + "b"; // javac 在编译期间的优化，结果已经在编译期确定为ab，所以可以直接在串池中取值

        //System.out.println(s3 == s4); // false
        //System.out.println(s3 == s5); // true
    }
}
/*
D:\workspace_backend\jvm_learning_heima\target\classes\com\it\demo>javap -v Demo1_22.class

Classfile /D:/workspace_backend/jvm_learning_heima/target/classes/com/it/demo/Demo1_22.class
  Last modified 2020-12-9; size 707 bytes
  MD5 checksum f7d3a2a3f4fd96dc5f6a7554ff67bb8e
  Compiled from "Demo1_22.java"
public class com.it.demo.Demo1_22
  minor version: 0
  major version: 49
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #10.#30        // java/lang/Object."<init>":()V
   #2 = String             #31            // a
   #3 = String             #32            // b
   #4 = String             #33            // ab
   #5 = Class              #34            // java/lang/StringBuilder
   #6 = Methodref          #5.#30         // java/lang/StringBuilder."<init>":()V
   #7 = Methodref          #5.#35         // java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   #8 = Methodref          #5.#36         // java/lang/StringBuilder.toString:()Ljava/lang/String;
   #9 = Class              #37            // com/it/demo/Demo1_22
  #10 = Class              #38            // java/lang/Object
  #11 = Utf8               <init>
  #12 = Utf8               ()V
  #13 = Utf8               Code
  #14 = Utf8               LineNumberTable
  #15 = Utf8               LocalVariableTable
  #16 = Utf8               this
  #17 = Utf8               Lcom/it/demo/Demo1_22;
  #18 = Utf8               main
  #19 = Utf8               ([Ljava/lang/String;)V
  #20 = Utf8               args
  #21 = Utf8               [Ljava/lang/String;
  #22 = Utf8               s1
  #23 = Utf8               Ljava/lang/String;
  #24 = Utf8               s2
  #25 = Utf8               s3
  #26 = Utf8               s4
  #27 = Utf8               s5
  #28 = Utf8               SourceFile
  #29 = Utf8               Demo1_22.java
  #30 = NameAndType        #11:#12        // "<init>":()V
  #31 = Utf8               a
  #32 = Utf8               b
  #33 = Utf8               ab
  #34 = Utf8               java/lang/StringBuilder
  #35 = NameAndType        #39:#40        // append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
  #36 = NameAndType        #41:#42        // toString:()Ljava/lang/String;
  #37 = Utf8               com/it/demo/Demo1_22
  #38 = Utf8               java/lang/Object
  #39 = Utf8               append
  #40 = Utf8               (Ljava/lang/String;)Ljava/lang/StringBuilder;
  #41 = Utf8               toString
  #42 = Utf8               ()Ljava/lang/String;
{
  public com.it.demo.Demo1_22();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 7: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lcom/it/demo/Demo1_22;

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=6, args_size=1
         0: ldc           #2                  // String a
         2: astore_1
         3: ldc           #3                  // String b
         5: astore_2
         6: ldc           #4                  // String ab
         8: astore_3
         9: new           #5                  // class java/lang/StringBuilder
        12: dup
        13: invokespecial #6                  // Method java/lang/StringBuilder."<init>":()V
        16: aload_1
        17: invokevirtual #7                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        20: aload_2
        21: invokevirtual #7                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        24: invokevirtual #8                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
        27: astore        4
        29: ldc           #4                  // String ab
        31: astore        5
        33: return
      LineNumberTable:
        line 10: 0
        line 11: 3
        line 12: 6
        line 13: 9
        line 14: 29
        line 15: 33
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      34     0  args   [Ljava/lang/String;
            3      31     1    s1   Ljava/lang/String;
            6      28     2    s2   Ljava/lang/String;
            9      25     3    s3   Ljava/lang/String;
           29       5     4    s4   Ljava/lang/String;
           33       1     5    s5   Ljava/lang/String;
}
SourceFile: "Demo1_22.java"


 */
