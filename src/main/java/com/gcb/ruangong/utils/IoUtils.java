package com.gcb.ruangong.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 古春波
 * @Description 用于文件的输入输出
 * @Date 2020/9/24 14:42
 * @Version 1.0
 **/
public class IoUtils {

    /**
     * 读入文件转化为
     * @param path
     * @return
     */
    public static List<String> initContentList(String path) {
        List<String> list = new ArrayList<>();
        File file = new File(path);
        if(! file.exists()){
            System.out.println(path + "文件不存在!");
            return list;
        }
        FileInputStream fis ;
        try {
            fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while((line=br.readLine())!=null)
            {
                line = line.trim();
                //过滤空格后如果!isEmpty()说明不是空行，可以添加进list
                if(!line.isEmpty())
                {
                    list.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 输出文件
     * @param outputFilePath 输出文件的路径
     * @param result 字符串形式传入结果
     */
    public static void convertString2File(String outputFilePath,String result){
        //创建输出路径的文件
        File outputFile = new File(outputFilePath);
/*        if(! outputFile.exists()){
            System.out.println("输出文件路径无效，答案无法输出，请检查参数 !");
            return;
        }*/
        //写入
        try (FileWriter fr = new FileWriter(outputFile)) {
            char[] cs = result.toCharArray();
            fr.write(cs);
            fr.close();
            System.out.println("The result has been written into " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}