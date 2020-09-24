package com.gcb.ruangong.utils;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;

import java.util.List;
import java.util.Map;

/**
 * @Author 古春波
 * @Description jieba分词工具类
 * @Date 2020/9/24 11:14
 * @Version 1.0
 **/
public class JieBaAnalysisUtils {
    
    /**
     * 使用jieba分词进行分词
     *
     * @param article  文章 
     * @param index 0代表原文 1代表抄袭的文章
     * @param wordMap  字数统计map
     */
    public static void textSegment(List<String> article, int index, Map<String, int[]> wordMap) {
        List<SegToken> segTokenList;
        for (String sentence : article) {
            //分词得到List<SegToken>,可通过 SegToken.word得到分词
            segTokenList = new JiebaSegmenter().process(sentence, JiebaSegmenter.SegMode.INDEX);
            putWordIntoMap(segTokenList, index, wordMap);
        }
    }

    /**
     * 求出词频
     *
     * @param segTokenList 分好的词集合
     * @param index  0代表原文 1代表抄袭的文章
     * @param wordMap  字数统计map
     */
    private static void putWordIntoMap(List<SegToken> segTokenList, int index, Map<String, int[]> wordMap) {
        for (SegToken segToken : segTokenList) {
            String word = segToken.word;
            //如果存在分词，就将分词频数加一
            if (wordMap.containsKey(word)) {
                wordMap.get(word)[index]++;
            } else {
                int[] count = new int[2];
                //如果不存在，就将相应文章的分词频数置1/0，并将分词放入map中
                count[0] = index == 0 ? 1 : 0;
                count[1] = index == 1 ? 1 : 0;
                wordMap.put(word, count);
            }
        }
        //到最后，map里的key对应的数组，第一个位置存储的是第一个字符串字符对应的向量，第二个位置存储的是第二个字符串字符对应的向量。
    }

}
