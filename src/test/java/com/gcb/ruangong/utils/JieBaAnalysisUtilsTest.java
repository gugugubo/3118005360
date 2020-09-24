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
            MainEntrance.process("src/test/resources/orig.txt","src/test/resources/orig_0.8_rep.txt");
        }
        catch (Exception e) {
            e.printStackTrace();
            // 如果抛出异常，证明测试失败,没有通过，没通过的测试计数在Failures中
            Assert.fail();
        }
    }
}