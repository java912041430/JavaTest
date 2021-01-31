package org.java.string;

public class StringBuilder {

    public static void main(String[] args) {
        java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder(10);
        stringBuilder.append("小哲...");
        System.out.println(stringBuilder);
        stringBuilder.append("这是什么?");
        System.out.println(stringBuilder);
        stringBuilder.insert(5,"哈哈!");
        System.out.println(stringBuilder);
        stringBuilder.delete(8,9);
        System.out.println(stringBuilder);

    }

}
