package com.zh;

import com.alibaba.fastjson.JSON;

import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


import org.apache.commons.codec.binary.Hex;

public class Test1 {
    public static String generate(String password) {
//        String uuid = UUID.randomUUID().toString();
//        String s = uuid.replaceAll("-", "");
//        System.out.println(s);
        Random r = new Random();
        StringBuilder sb = new StringBuilder(16);
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        String salt = sb.toString();
        password = md5Hex(password + salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return new String(cs);
    }

    /**
     * 校验密码是否正确
     */
    public static boolean verify(String password, String md5) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5.charAt(i);
            cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);
            cs2[i / 3] = md5.charAt(i + 1);
        }
        String salt = new String(cs2);
        return md5Hex(password + salt).equals(new String(cs1));
    }

    /**
     * 获取十六进制字符串形式的MD5摘要
     */
    public static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }



    public static void main(String[] args) throws ParseException {

//        String password = generate("admin");
//        System.out.println(verify("admin", password));
//
//
//        List list = new ArrayList();

//        Map<String, String> map = new HashMap<>();
//        map.put("appId", "12312324");
//        map.put("_timestamp", System.currentTimeMillis() + "");
//        map.put("consNo", "os93094");
//        String json = JSON.toJSONString(map);
//        System.out.println(json);
//
//        long totalMilliSeconds = System.currentTimeMillis();
//        long totalSeconds = totalMilliSeconds / 1000;
//
//        //求出现在的秒
//        long currentSecond = totalSeconds % 60;
//
//        //求出现在的分
//        long totalMinutes = totalSeconds / 60;
//        long currentMinute = totalMinutes % 60;
//
//        //求出现在的小时
//        long totalHour = totalMinutes / 60;
//        long currentHour = totalHour % 24;
//
//        //显示时间
//        System.out.println("总毫秒为： " + totalMilliSeconds);
//        System.out.println(currentHour + ":" + currentMinute + ":" + currentSecond + " GMT");



//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateTostr = sdf.format(new Date());
//        System.out.println(dateTostr);
//
//
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
//        String dateTostr1 = sdf1.format(new Date());
//        System.out.println(dateTostr1);
//
//
//        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMM");
//        String dateTostr2 = sdf2.format(new Date());
//        System.out.println(dateTostr2);
//
//
//        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
//        String dateTostr3 = sdf3.format(new Date());
//        System.out.println(dateTostr3);


//        String date = "20201214";
//        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
//        String dateTostr3 = sdf3.format(date);
//        System.out.println(dateTostr3);

        String time = "20120324";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
// SimpleDateFormat的parse(String time)方法将String转换为Date
        Date date = simpleDateFormat.parse(time);
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
// SimpleDateFormat的format(Date date)方法将Date转换为String
        String formattedTime = simpleDateFormat.format(date);
        System.out.println("---->将" + time + "解析为:" + formattedTime);
    }
}
