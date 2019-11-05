package com.ann.bronze.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/**
 * @Description 使用MessageDigest加密获取摘要
 * @Author painter
 * @Date 09:52 2019-11-05
 * @see https://blog.csdn.net/fjjjyf/article/details/83788574
 * @see https://www.jb51.net/article/128927.htm
 **/

public class MessageDigestDemo {
    public static void main(String[] args) {
        String result = sign("hello");
        System.out.println(result);
    }

    private static String sign(String input) {
        String signature = "";

        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(input.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        }
        catch (NoSuchAlgorithmException | UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        return signature;
    }

    //字节用16进制表示，两个字符
    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
}
