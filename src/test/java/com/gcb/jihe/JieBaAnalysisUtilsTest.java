package com.gcb.jihe;

import com.gcb.ruangong.duplicatecheck.MainEntrance;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * @Author 古春波
 * @Description 测试类
 * @Date 2020/9/24 15:04
 * @Version 1.0
 **/
public class JieBaAnalysisUtilsTest extends TestCase {


    /**
     * 测试源文件路径为null的情况
     */
    @Test
    public void testForOriginalArticleNull(){
        MainEntrance.start(null,"src/test/resources/article/orig_0.8_del.txt","src/test/resources/result/testRepResult.txt");
    }


    /**
     * 测试对比文件路径为null的情况
     */
    @Test
    public void testForPlagiarismArticleNull(){
        MainEntrance.start("src/test/resources/article/orig.txt",null,"src/test/resources/result/testRepResult.txt");
    }
    
    /**
     * 测试结果输出文件路径为null的情况
     */
    @Test
    public void testForResultNull(){
        MainEntrance.start("src/test/resources/article/orig.txt","src/test/resources/article/orig_0.8_del.txt",null);
    }


    /**
     * 测试路径不存在的情况
     */
    @Test
    public void testForNotExistFile(){
        MainEntrance.start("src/test/resources/article/orig2.txt","src/test/resources/article/orig_0.8_del.txt",null);
    }


    /**
     * 测试输入对比的文件内容为空的情况
     */
    @Test
    public void testForEmpty(){
        MainEntrance.start("src/test/resources/article/orig.txt","src/test/resources/article/empty.txt","src/test/resources/result/testForEmpty.txt");
    }

    /**
     * 测试对比orig_0.8_add.txt
     */
    @Test
    public void testForAdd(){
        MainEntrance.start("src/test/resources/article/orig.txt","src/test/resources/article/orig_0.8_add.txt","src/test/resources/result/testForAdd.txt");
    }


    /**
     * 测试对比orig_0.8_del.txt
     */
    @Test
    public void testForDel(){
        MainEntrance.start("src/test/resources/article/orig.txt","src/test/resources/article/orig_0.8_del.txt","src/test/resources/result/testForDel.txt");
    }

    /**
     * 测试对比orig_0.8_dis_1.txt.txt
     */
    @Test
    public void testForDis1(){
        MainEntrance.start("src/test/resources/article/orig_0.8_dis_1.txt","src/test/resources/article/orig_0.8_dis_1.txt","src/test/resources/result/testForDis1.txt");
    }


    /**
     * 测试对比orig_0.8_dis_10.txt
     */
    @Test
    public void testForAdd10(){
        MainEntrance.start("src/test/resources/article/orig_0.8_dis_1.txt","src/test/resources/article/orig_0.8_dis_10.txt","src/test/resources/result/testForAdd10.txt");
    }


    /**
     * 测试对比orig_0.8_dis_15.txt
     */
    @Test
    public void testForDis15(){
        MainEntrance.start("src/test/resources/article/orig_0.8_dis_1.txt","src/test/resources/article/orig_0.8_dis_15.txt","src/test/resources/result/testForDis15.txt");
    }


}