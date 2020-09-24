package com.gcb.ruangong.duplicatecheck;

import com.gcb.ruangong.utils.CalculationUtils;
import com.gcb.ruangong.utils.IoUtils;

import java.io.File;
import java.util.List;

/**
 * @Author 古春波
 * @Description 程序入口类
 * @Date 2020/9/24 15:10
 * @Version 1.0
 **/
public class MainEntrance {
    
    public static void main( String[] args ) {
        process(args[0],args[1]);
        System.exit(0);
    }
 
    public static void process(String originalArticle,String plagiarismArticle){
        File originalFile = new File(originalArticle);
        File plagiarismFile = new File(plagiarismArticle);
        if(! originalFile.exists() || ! plagiarismFile.exists()){
            System.out.println("文件不存在");
            return;
        }
        List<String> originalString = IoUtils.initContentList(originalArticle);
        List<String> plagiarismString = IoUtils.initContentList(plagiarismArticle);
        double result = CalculationUtils.getSimResult(originalString , plagiarismString);
        //控制台输出
        System.out.println("计算得出的相似度为  : "  + result);
    }
    
    
}
