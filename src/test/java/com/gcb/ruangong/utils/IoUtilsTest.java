package com.gcb.ruangong.utils;

import junit.framework.TestCase;

import java.io.File;
import java.util.List;

/**
 * @Author 古春波
 * @Description TODO
 * @Date 2020/9/24 17:47
 * @Version 1.0
 **/
public class IoUtilsTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void testInitContentList() {
        String path = "src/test/resources/article/orig.txt";
        File originalFile = new File(path);
        File plagiarismFile = new File(path);
        if(! originalFile.exists() || ! plagiarismFile.exists()){
            System.out.println("文件不存在");
            return;
        }
        List<String> originalString = IoUtils.initContentList(path);
        System.out.println(" 读取成功 + " +originalString);
    }

    public void testSaveFile() {
        String path = "src/test/resources/article/outputTest.txt";
        IoUtils.saveFile(path,"尝试保存一个文件到指定路径");
    }
}