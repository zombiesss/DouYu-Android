package com.mayi.douyu.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 作者 by yugai 时间 16/11/25.
 * ＊ 邮箱 784787081@qq.com
 */

public class MD5 {
    public static String strToMd5Low32(String str) {
        StringBuilder builder = new StringBuilder();
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes());
            byte[] bytes = md5.digest();
            for (byte b : bytes) {
                int digital = b&0xff;
                if (digital < 16)
                    builder.append(0);
                builder.append(Integer.toHexString(digital));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return builder.toString().toLowerCase();
    }
}
