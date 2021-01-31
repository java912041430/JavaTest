package org.java.io;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

public class IODemo {

    public static void main(String[] args) throws Exception{
//        copy();
//        copyNIO();
        copyFileUsingJava7Files();
    }

    //使用FileStreams复制
    private static void copy() throws IOException {
        File inputFile = new File("C:\\Users\\NAME_CHENZHE\\Pictures\\照片\\001e8c9cb843b0f668fac70f762be6c6e4412077.png");
        File outputFile = new File("F:\\TestDemo\\Re\\居居.png");

        InputStream inputStream = new FileInputStream(inputFile);
        OutputStream outputStream = new FileOutputStream(outputFile);

        byte[] bytes = new byte[1024];

        int len;

        while((len=inputStream.read(bytes))>0){
            outputStream.write(bytes,0,len);
        }

        inputStream.close();
        outputStream.close();
    }

    //使用FileChannel
    private static void copyNIO() throws Exception{
        File inputFile = new File("C:\\Users\\NAME_CHENZHE\\Pictures\\照片\\001e8c9cb843b0f668fac70f762be6c6e4412077.png");
        File outputFile = new File("F:\\TestDemo\\Re\\居居01.png");

        FileChannel input = new FileInputStream(inputFile).getChannel();
        FileChannel output = new FileOutputStream(outputFile).getChannel();
        output.transferFrom(input,0,input.size());

        input.close();
        output.close();
    }

    //使用java7的Files类复制
    private static void copyFileUsingJava7Files() throws IOException {
        File inputFile = new File("C:\\Users\\NAME_CHENZHE\\Pictures\\照片\\001e8c9cb843b0f668fac70f762be6c6e4412077.png");
        File outputFile = new File("F:\\TestDemo\\Re\\居居02.png");
        Files.copy(inputFile.toPath(),outputFile.toPath());
    }




}
