package com.gcb.jihe;

import com.gcb.ruangong.duplicatecheck.MainEntrance;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class MainApplicationTest {

    @BeforeClass
    public static void beforeTest(){
        System.out.println("测试即将开始");
    }

    @AfterClass
    public static void afterTest(){
        System.out.println("测试结束");
    }


    /**
     * 测试 文本为空文本的情况
     */
    @Test
    public void testForEmpty(){
         MainEntrance.start("src/test/resources/testcase/orig.txt","src/test/resources/testcase/empty.txt","src/test/resources/result/testEmptyResult.txt");
    }

    /**
     * 测试 输入的对比文本路径参数为错误参数的情况
     */
    @Test
    public void testForWrongOriginArgument(){
        MainEntrance.start("src/test/resources/testcase/123.txt","src/test/resources/testcase/orig_0.8_add.txt","src/test/resources/result/testAddResult.txt");

    }

    /**
     * 测试 输出文件路径参数为错误参数的情况
     */
    @Test
    public void testForWrongOutputArgument(){
        MainEntrance.start("src/test/resources/testcase/orig.txt","src/test/resources/testcase/orig.txt","src/test/resources/result/testAWrongArgumentResult");
        
    }

    /**
     * 测试20%文本添加情况：orig_0.8_add.txt
     */
    @Test
    public void testForAdd(){
        MainEntrance.start("src/test/resources/testcase/orig.txt","src/test/resources/testcase/orig_0.8_add.txt","src/test/resources/result/testAddResult.txt");
        
    }

    /**
     * 测试20%文本删除情况：orig_0.8_del.txt
     */
    @Test
    public void testForDel(){
        MainEntrance.start("src/test/resources/testcase/orig.txt","src/test/resources/testcase/orig_0.8_del.txt","src/test/resources/result/testDelResult.txt");

    }

    /**
     * 测试20%文本乱序情况：orig_0.8_dis_1.txt
     */
    @Test
    public void testForDis1(){
        MainEntrance.start("src/test/resources/testcase/orig.txt","src/test/resources/testcase/orig_0.8_dis_1.txt","src/test/resources/result/testDis1Result.txt");

    }

    /**
     * 测试20%文本乱序情况：orig_0.8_dis_3.txt
     */
    @Test
    public void testForDis3(){
        MainEntrance.start("src/test/resources/testcase/orig.txt","src/test/resources/testcase/orig_0.8_dis_3.txt","src/test/resources/result/testDis3Result.txt");

    }

    /**
     * 测试20%文本乱序情况：orig_0.8_dis_7.txt
     */
    @Test
    public void testForDis7(){
        MainEntrance.start("src/test/resources/testcase/orig.txt","src/test/resources/testcase/orig_0.8_dis_7.txt","src/test/resources/result/testDis7Result.txt");
    }

    /**
     * 测试20%文本乱序情况：orig_0.8_dis_10.txt
     */
    @Test
    public void testForDis10(){
        MainEntrance.start("src/test/resources/testcase/orig.txt","src/test/resources/testcase/orig_0.8_dis_10.txt","src/test/resources/result/testDis10Result.txt");
    }

    /**
     * 测试20%文本乱序情况：orig_0.8_dis_15.txt
     */
    @Test
    public void testForDis15() {
        MainEntrance.start("src/test/resources/testcase/orig.txt", "src/test/resources/testcase/orig_0.8_dis_15.txt", "src/test/resources/result/testDis15Result.txt");
    }

    /**
     * 测试20%文本格式错乱情况：orig_0.8_mix.txt
     */
    @Test
    public void testForMix(){
        MainEntrance.start("src/test/resources/testcase/orig.txt","src/test/resources/testcase/orig_0.8_mix.txt","src/test/resources/result/testMixResult.txt");
    }

    /**
     * 测试20%文本错别字情况：orig_0.8_rep.txt
     */
    @Test
    public void testForRep(){
        MainEntrance.start("src/test/resources/testcase/orig.txt","src/test/resources/testcase/orig_0.8_rep.txt","src/test/resources/result/testRepResult.txt");
    }


    
    /**
     * 测试相同文本：orig.txt
     */
    @Test
    public void testForSame(){
        MainEntrance.start("src/test/resources/testcase/orig.txt","src/test/resources/testcase/orig.txt","src/test/resources/result/testSameResult.txt");
    }


    @Test
    public void testForSub(){
        MainEntrance.start("src/test/resources/testcase/orig.txt","src/test/resources/testcase/orig_sub.txt","src/test/resources/result/testSubResult.txt");
    }

}
