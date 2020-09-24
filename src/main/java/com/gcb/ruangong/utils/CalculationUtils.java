package com.gcb.ruangong.utils;

import java.util.*;

/**
 * @Author 古春波
 * @Description 使用余弦定理计算相似度
 * @Date 2020/9/24 11:59
 * @Version 1.0
 **/
public class CalculationUtils {
    
    static Map<String, int[]> wordMap = new HashMap<>();

    public static double getSimResult(List<String> originalArticle,  List<String> plagiarismArticle){
        JieBaAnalysisUtils.textSegment(originalArticle,0, wordMap);
        JieBaAnalysisUtils.textSegment(plagiarismArticle,1, wordMap);
        double sim = sim();
        return sim;
    }
    
    
    /**
     * 求余弦相似度
     * @return 相似度
     */
    private static double sim() {
        //分子分母相除
        double result;
        result = pointMulti(wordMap) / sqrtMulti(wordMap);
        //余弦度结果返回,因为是余弦，返回结果越大，夹角越小，两个向量方向越接近，即两个字符串越相似
        return result;   
    }

    /**
     * 求平方根
     * @param paramMap 字数统计map
     * @return 求平方根计算结果
     */
    private static double sqrtMulti(Map<String, int[]> paramMap) {
        double result;
        //先求平方和
        result = squares(paramMap);
        //再开根号，就是求模
        result = Math.sqrt(result);
        return result;
    }

    /**
     * 求平方和，分母上，向量求模的平方
     * @param paramMap  字数统计map
     * @return 求平方和计算结果
     */
    private static double squares(Map<String, int[]> paramMap) {
        double result1 = 0;
        double result2 = 0;
        Set<String> keySet = paramMap.keySet();
        for (String string : keySet) {
            //获取key对应的值--数组
            int[] temp = paramMap.get(string);
            //temp[0]存储的是第一个字符串对应的向量
            result1 += (temp[0] * temp[0]);
            //temp[1]存储的是第二个字符串对应的向量
            result2 += (temp[1] * temp[1]);
        }
        return result1 * result2;
    }

    /**
     * 点乘法，在分子上，向量相乘
     * @param paramMap  字数统计map
     * @return 点乘计算结果 
     */
    private static double pointMulti(Map<String, int[]> paramMap) {
        double result = 0;
        // 返回map中所有key值的列表，这里的set，也可以用list代替吧
        Set<String> keySet = paramMap.keySet();
        //存储的key值都是不重复的
        for (String string : keySet) {
            //获取key对应的值
            int[] temp = paramMap.get(string);   
            result += (temp[0] * temp[1]);
        }
        return result;
    }


    public  static void main(String[] args) {
        String s1 = "这只皮靴号码大了。那只号码合适";
        List<String> list1 = new ArrayList<>();
        list1.add(s1);
        List<String> list2 = new ArrayList<>();
        String s2 = "这只皮靴号码不小，那只更合适";
        list2.add(s2);
        JieBaAnalysisUtils.textSegment(list1,0, wordMap);
        JieBaAnalysisUtils.textSegment(list2,1, wordMap);
        System.out.println(sim());
    }   
    
  


}
