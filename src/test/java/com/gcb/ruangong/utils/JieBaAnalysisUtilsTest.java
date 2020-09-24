package com.gcb.ruangong.utils;

import com.gcb.ruangong.duplicatecheck.MainEntrance;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author 古春波
 * @Description 测试类
 * @Date 2020/9/24 15:04
 * @Version 1.0
 **/
public class JieBaAnalysisUtilsTest extends TestCase {


    /**
     * 测试20%文本错别字情况：orig_0.8_rep.txt
     */
    @Test
    public void testForRep(){
        try {
            MainEntrance.start("src/test/resources/article/orig.txt","src/test/resources/article/orig_0.8_del.txt","src/test/resources/result/testRepResult.txt");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
}