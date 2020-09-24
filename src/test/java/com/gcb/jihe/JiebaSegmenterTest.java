/**
 * 
 */
package com.gcb.jihe;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.JiebaSegmenter.SegMode;
import com.huaban.analysis.jieba.SegToken;
import com.huaban.analysis.jieba.WordDictionary;
import junit.framework.TestCase;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;


/**
 * jieba 包测试类
 */
public class JiebaSegmenterTest extends TestCase {
    private final JiebaSegmenter segmenter = new JiebaSegmenter();
    
    @Override
    protected void setUp()  {
        WordDictionary.getInstance().init(Paths.get("conf"));
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    

    @Test
    public void testBugSentence() {
        String[] bugs =
                new String[] {
                              "UTF-8",
                              "iphone5",
                              "鲜芋仙 3",
                              "RT @laoshipukong : 27日，",
                              "AT&T是一件不错的公司，给你发offer了吗？",
                              "干脆就把那部蒙人的闲法给废了拉倒！RT @laoshipukong : 27日，全国人大常委会第三次审议侵权责任法草案，删除了有关医疗损害责任“举证倒置”的规定。在医患纠纷中本已处于弱势地位的消费者由此将陷入万劫不复的境地。 " };
        for (String sentence : bugs) {
            List<SegToken> tokens = segmenter.process(sentence, SegMode.SEARCH);
            System.out.print(String.format(Locale.getDefault(), "\n%s\n%s", sentence, tokens.toString()));
        }
    }

    

    @Test
    public void testDemo() {
        JiebaSegmenter segmenter = new JiebaSegmenter();
        String[] sentences =
                new String[] {"这是一个伸手不见五指的黑夜。我叫孙悟空，我爱北京，我爱Python和C++。", "我不喜欢日本和服。", "雷猴回归人间。",
                        "工信处女干事每月经过下属科室都要亲口交代24口交换机等技术性器件的安装工作", "结果婚的和尚未结过婚的"};
        for (String sentence : sentences) {
            System.out.println(segmenter.process(sentence, SegMode.SEARCH).toString());
        }
    }
}
