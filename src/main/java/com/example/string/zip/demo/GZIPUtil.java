package com.example.string.zip.demo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Gzip 基于 DEFLATE 算法
 */
public class GZIPUtil {
    // 压缩
    public static String compress(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(out);
        gzip.write(str.getBytes());
        gzip.close();
        return out.toString("ISO-8859-1");
    }

    // 解压缩
    public static String uncompress(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(str
                .getBytes("ISO-8859-1"));
        GZIPInputStream gunzip = new GZIPInputStream(in);
        byte[] buffer = new byte[256];
        int n;
        while ((n = gunzip.read(buffer)) >= 0) {
            out.write(buffer, 0, n);
        }
        // toString()使用平台默认编码，也可以显式的指定如toString("GBK")
        return out.toString();
    }

    // 测试方法
    public static void main(String[] args) throws IOException {
        String msg = "can you can a can as a can canner can a can.";
        System.out.println("压缩前的数据长度：" + msg.length());
        String tarStr = GZIPUtil.compress(msg);
        System.out.println("压缩后的数据长度：" + tarStr.length());
        System.out.println("压缩率：" + (msg.length() - tarStr.length()) * 1.0 / msg.length() * 100);
        System.out.println("压缩报文：" + tarStr);
        String sourceStr = GZIPUtil.uncompress(tarStr);
        System.out.println("原报文：" + sourceStr);
    }
}
