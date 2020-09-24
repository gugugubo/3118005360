package com.gcb.ruangong.utils;

import junit.framework.TestCase;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

/**
 * @Author 古春波
 * @Description 测试字符转换类
 * @Date 2020/9/24 17:35
 * @Version 1.0
 **/
public class NumberUtilsTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    /**
     * 测试将小数转化为百分数并且保留两位小数的方法
     */
    public void testGetPercentFormat() {
        Double aDouble = new Double(0.992323);
        String percentFormat = NumberUtils.getPercentFormat(aDouble, 2);
        Assert.assertEquals("99.23%", percentFormat );
        System.out.println(percentFormat);
    }
}