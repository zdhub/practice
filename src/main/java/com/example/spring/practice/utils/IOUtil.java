package com.example.spring.practice.utils;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName IOUtil
 * @Descirption java io 拷贝的四种方式
 * @Author yizhendong
 * @Date 22/7/2019
 **/
public class IOUtil {

    /**
     * 通过流来拷贝
     * @param source
     * @param dest
     * @throws IOException
     */
    public static void copyFileByStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int lenght ;
            while ((lenght = is.read(buffer)) > 0) {
                os.write(buffer, 0, lenght);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    /**
     * 通过FileChannel类的transferTo或者transferFrom
     */
    public static void copyFileByChannel(File source, File dest) throws IOException{
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destChannel = new FileOutputStream(dest).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sourceChannel.close();
            destChannel.close();
        }
    }

    /**
     * 使用apache 工具类，底层也是流
     * @param source
     * @param dest
     * @throws IOException
     */
    public static void copyFileByApacheCommonsIO(File source, File dest) throws IOException{
        FileUtils.copyFile(source, dest);
    }

    /**
     * java8以上，可以通过Files.copy
     * @param source
     * @param dest
     * @throws IOException
     */
    public static void copyFileByFileUtil(File source, File dest) throws IOException{
        Files.copy(source.toPath(), dest.toPath());
    }



    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String destName = "/Users/yizhendong/Desktop/" + localDateTime.format(DateTimeFormatter.ISO_LOCAL_TIME)+ ".sql";
        File source = new File("/Users/yizhendong/Desktop/sh_house_key.sql");
        File dest = new File(destName);
        try {
//            copyFileByStream(source, dest);
            copyFileByFileUtil(source, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
