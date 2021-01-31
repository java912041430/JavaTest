package org.java.io;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;
import org.java.util.PrintUtil;

public class FileDemo {

    //文件路径
    final static String PATH = "F:/TestDemo/Re";

    public static void main(String[] args) throws Exception{
        File file = new File(PATH);
        PrintUtil.printInfo(PATH+isFileOrDirectory(file));
        String[] list = file.list(new DirFilter("123.txt"));
        if(list == null){
            return;
        }
        for (String msg: list) {
            msg = PATH+"/"+msg;
            PrintUtil.printInfo(msg+isFileOrDirectory(new File(msg)));

        }
        file = new File(PATH+"/哈哈.txt");
        createFile(file,true);
        OutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
        outputStreamWriter.append("中文");
        outputStreamWriter.append("哈哈");
        outputStreamWriter.close();
        outputStream.close();
        outputStream.close();
    }

    //判断file（文件/文件夹）
    private static String isFileOrDirectory(File file){
        StringBuilder returnInfo =  new StringBuilder("[file对象为空!]");
        if(file == null){
            return returnInfo.toString();
        }
        returnInfo.delete(0,returnInfo.length());
        if(file.isFile()){
            returnInfo.append("[文件]");
        }else if(file.isDirectory()){
            returnInfo.append("[文件夹]");
        }
        return returnInfo.toString();
    }

    //创建文件夹
    private static void createFile(File file,boolean isFile){
        if(file.exists()){
            PrintUtil.printInfo(isFile?"文件已存在":"文件夹已存在");
            return;
        }

        if(isFile){
            boolean newFile = false;
            try {
                newFile = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("异常："+e+",文件创建：失败");
            }
            System.out.println("文件创建："+(newFile?"成功":"失败"));
        }else{
            boolean mkdirs = file.mkdirs();
            System.out.println("文件夹创建："+(mkdirs?"成功":"失败"));
        }
    }

    //删除(文件/文件夹)
    private static void deleteFile(File file){
        boolean delete = file.delete();
        System.out.println("文件夹删除："+(delete?"成功":"失败"));
    }
}
