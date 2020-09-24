package com.gcb.ruangong;

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


 
    public static void process(String orgTextPath,String newTextPath){
        File originFile = new File(orgTextPath);
        File newFile = new File(newTextPath);
        if(! originFile.exists() || ! newFile.exists()){
            System.out.println("The file path is invalid, please check the file path parameter !\n");
            return;
        }
        List<String> orgString = IoUtils.initContentList(orgTextPath);
        List<String> newString = IoUtils.initContentList(newTextPath);
        //执行计算
        double ans = CalculationUtils.getSimResult(orgString , newString);
       
        //控制台输出
        System.out.println("Similar Score  : "  + ans);
    }
    
    
}
