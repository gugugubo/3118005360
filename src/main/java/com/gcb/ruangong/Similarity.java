package com.gcb.ruangong;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author 古春波
 * @Description 字符串相似性匹配算法
 * @Date 2020/9/24 9:29
 * @Version 1.0
 **/
public class Similarity {
    Map<Character, int[]> vectorMap = new HashMap<Character, int[]>();

    int[] tempArray = null;

    public Similarity(String string1, String string2) {

        for (Character character1 : string1.toCharArray()) {  //拆解为向量
            if (vectorMap.containsKey(character1)) {   //该字符是否已经存在map中
                vectorMap.get(character1)[0]++;   //key对应的值是一个数组，第一个字符串的字符出现次数存储在数组第一个位置
            } else {
                tempArray = new int[2];
                tempArray[0] = 1;  //如果字符没有出现过，就添加到map中，数组第一个位置设为1
                tempArray[1] = 0;
                vectorMap.put(character1, tempArray);
            }
        }
        for (Character character2 : string2.toCharArray()) {  //拆解为向量
            if (vectorMap.containsKey(character2)) {
                vectorMap.get(character2)[1]++;
            } else {
                tempArray = new int[2];
                tempArray[0] = 0;
                tempArray[1] = 1;  //第二个字符串的字符出现次数存储在数组的第二个位置
                vectorMap.put(character2, tempArray);
            }
        }
        /*
         * 到最后，map里的key对应的数组，第一个位置存储的是第一个字符串字符对应的向量，第二个位置存储的是第二个字符串字符对应的向量。
         */
    }

    // 求余弦相似度
    public double sim() {   //分子分母相除
        double result = 0;
        result = pointMulti(vectorMap) / sqrtMulti(vectorMap);
        return result;    //余弦度结果返回,因为是余弦，返回结果越大，夹角越小，两个向量方向越接近，即两个字符串越相似
    }

    //求平方根
    private double sqrtMulti(Map<Character, int[]> paramMap) {
        double result = 0;
        //先求平方和
        result = squares(paramMap);
        //再开根号，就是求模
        result = Math.sqrt(result); 
        return result;
    }

    /**
     * 求平方和，分母上，向量求模的平方
     * @param paramMap
     * @return
     */
    private double squares(Map<Character, int[]> paramMap) {
        double result1 = 0;
        double result2 = 0;
        Set<Character> keySet = paramMap.keySet();
        for (Character character : keySet) {
            //获取key对应的值--数组
            int temp[] = paramMap.get(character);
            //temp[0]存储的是第一个字符串对应的向量
            result1 += (temp[0] * temp[0]);
            //temp[1]存储的是第二个字符串对应的向量
            result2 += (temp[1] * temp[1]);  
        }
        return result1 * result2;
    }

    // 点乘法，在分子上，向量相乘
    private double pointMulti(Map<Character, int[]> paramMap) {
        double result = 0;
        Set<Character> keySet = paramMap.keySet();  //返回map中所有key值的列表，这里的set，也可以用list代替吧
        for (Character character : keySet) {    //存储的key值都是不重复的
            int temp[] = paramMap.get(character);   //获取key对应的值
            result += (temp[0] * temp[1]);
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "这只皮靴号码大了。那只号码合适";
        String s2 = "这只皮靴号码不小，那只更合适";
        

        Similarity similarity = new Similarity(s1, s2);
        System.out.println(similarity.sim());
    }

}