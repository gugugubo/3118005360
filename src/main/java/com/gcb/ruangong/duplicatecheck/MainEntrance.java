package com.gcb.ruangong.duplicatecheck;

import com.gcb.ruangong.utils.CalculationUtils;
import com.gcb.ruangong.utils.IoUtils;
import com.gcb.ruangong.utils.NumberUtils;

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
        start(args[0],args[1],args[2]);
        System.exit(0);
    }
 
    public static void start(String originalArticle, String plagiarismArticle , String desFilePath){
        File originalFile = new File(originalArticle);
        File plagiarismFile = new File(plagiarismArticle);
        if(! originalFile.exists() || ! plagiarismFile.exists()){
            System.out.println("文件不存在");
            return;
        }
        List<String> originalString = IoUtils.initContentList(originalArticle);
        List<String> plagiarismString = IoUtils.initContentList(plagiarismArticle);
        double result = CalculationUtils.getSimResult(originalString , plagiarismString);
        String percentFormat = NumberUtils.getPercentFormat(result, 2);
        IoUtils.saveFile(desFilePath, "源文件的路径： " + originalArticle+"\n"
                +"对比文件的路径： " + plagiarismArticle +"\n"
                +"两篇文章的相似度为 ：" + percentFormat);
        System.out.println("计算得出的相似度为  : "  + percentFormat);
    }
    
    
}
