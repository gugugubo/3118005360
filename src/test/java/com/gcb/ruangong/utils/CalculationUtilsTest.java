package com.gcb.ruangong.utils;

import junit.framework.TestCase;

import java.util.*;

/**
 * @Author 古春波
 * @Description CalculationUtilsTest测试
 * @Date 2020/9/24 17:40
 * @Version 1.0
 **/
public class CalculationUtilsTest extends TestCase {

    static Map<String, int[]> wordMap = new HashMap<>();


    /**
     * 测试分词的功能，并且将词频保存在wordMap中
     */
    public void testGetSimResult() {
        String s1 = "这只皮靴号码大了。那只号码合适";
        List<String> list1 = new ArrayList<>();
        list1.add(s1);
        List<String> list2 = new ArrayList<>();
        String s2 = "这只皮靴号码不小，那只更合适";
        list2.add(s2);
        JieBaAnalysisUtils.textSegment(list1,0, wordMap);
        JieBaAnalysisUtils.textSegment(list2,1, wordMap);
        Set<String> strings = wordMap.keySet();
        strings.forEach(key ->{
            System.out.println(key);
            System.out.println("句子一：" + wordMap.get(key)[0] + "  句子二：" +  wordMap.get(key)[1]);
        });
    }
}