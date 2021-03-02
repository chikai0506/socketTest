package com.zh;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


public class Test6 {
    public static void main(String[] args) throws IOException {
//        int num = 123;
//        String str = String.format("%08d",num);
//        System.out.println(str);


//        String payId="898208";
//        String dataType="0020";
//        String seriNO="999999";
//
//        String requset = dataType+"|"+payId+"|"+seriNO;
//        int requsetLen = requset.length();
//        String str = String.format("%08d",requsetLen);
//        String dataTop = str+dataType;
//        System.out.println(dataTop);

//        String str = "[{'columnId':5,'columnName':'人文历史','totalAmt':2.9},{'columnId':2,'columnName':'商业视野'}]";
//        JSONArray jsonArray = JSONArray.parseArray(str);
//        for (int i = 0; i < jsonArray.size(); i++) {
////            String array = (String) jsonArray.getJSONObject(i).get("columnName");
//            BigDecimal totalAmt = (BigDecimal) jsonArray.getJSONObject(i).get("totalAmt");
//            System.out.println(totalAmt);

//        }


//        String jsonMessage = "{'code':0,'msg':'处理成功','result':{'accessToken':'abcdefghijklmnopqrstuvwxyz'}}";
//
//        JSONObject jsonObject = JSON.parseObject(jsonMessage);
//
//        String respCode = jsonObject.getString("code");
//        String respMsg = jsonObject.getString("msg");
//        JSONObject result = jsonObject.getJSONObject("result");
//        String accessToken = result.getString("accessToken");
//        System.out.println(respCode+"-----"+respMsg+"------"+accessToken+"------"+result);

        String jsonMessage = "{'code':0,'msg':'处理成功','result':{'accessToken':'abcdefghijklmnopqrstuvwxyz'}}";
        JSONObject jsonObject = JSON.parseObject(jsonMessage);
        JSONObject result = jsonObject.getJSONObject("result");
//        String s = JSON.toJSONString(result);
//        Map<String, Object> resultMap = new HashMap<>();
//循环转换
//        for (Map.Entry<String, Object> entry : result.entrySet()) {
//            resultMap.put(entry.getKey(), entry.getValue());
//        }

        String path = "C:\\Users\\ckhh2017\\Desktop\\test.txt";
        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
        // write 向test4.txt中写入文件；
        //如果FileWriter的构造参数为true，那么就进行内容追加;
        //如果FileWriter的构造参数为false,那么就进行内容的覆盖;
        FileWriter fw = new FileWriter(file, false);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(result.getString("accessToken"));
        bw.flush();
        bw.close();
        fw.close();
//        FileUtil.writeUtf8Map(resultMap,file,":",false);
    }
}
