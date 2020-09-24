package com.gcb.ruangong.utils;

import java.text.NumberFormat;

/**
 * @Author 古春波
 * @Description 数制转化工具类
 * @Date 2020/9/24 17:18
 * @Version 1.0
 **/
public class NumberUtils {

    /**
     * 将double类型数据转换为百分比格式，并保留小数点前IntegerDigits位和小数点后FractionDigits位
     * @param d 要转化的小数 
     * @param FractionDigits 小数点后保留几位
     * @return
     */
    public static String getPercentFormat(double d,int FractionDigits){
        NumberFormat nf = java.text.NumberFormat.getPercentInstance();
        // 小数点后保留几位
        nf.setMinimumFractionDigits(FractionDigits);
        String str = nf.format(d);
        return str;
    }
}
