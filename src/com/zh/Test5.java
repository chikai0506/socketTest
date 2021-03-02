package com.zh;

import java.io.*;
import java.util.ArrayList;

public class Test5 {

    public static String readTxt(String filePath) {
        String accessToken = null;
        try {
            File file = new File(filePath);
            if(file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String lineTxt = null;
                while ((lineTxt = br.readLine()) != null) {
                    accessToken = lineTxt;
                }
                br.close();
            } else {
                System.out.println("文件不存在!");
            }
        } catch (Exception e) {
            System.out.println("文件读取错误!");
        }

        return accessToken;
    }


    public static void main(String[] args) {

        String filePath = "C:\\Users\\ckhh2017\\Desktop\\test.txt";
        String s = readTxt(filePath);
        System.out.println(s);
//        String str = "123";
//        int strLen = str.length();
//        StringBuffer sb = null;
//        while (strLen < 8) {
//            sb = new StringBuffer();
//            sb.append("0").append(str);// 左补0
////            sb.append(str).append("0");//右补0
//            str = sb.toString();
//            strLen = str.length();
//        }
//        System.out.println(str);
//        System.out.println(strLen);


    }
}
