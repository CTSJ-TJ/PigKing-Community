package Test;

import com.hankcs.hanlp.restful.HanLPClient;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class Test02 {
    public static void main(String[] args) throws IOException {

        HanLPClient HanLP = new HanLPClient("https://www.hanlp.com/api", "NTE4M0BiYnMuaGFubHAuY29tOmhyVW93bDZTMm9Qd3NpWnQ=");

        // 情感分析
        String text = "我很悲伤！！";
        double sentiment = HanLP.sentimentAnalysis(text);
        System.out.println(sentiment);  // 输出：返回值为文档的情感极性，表示为 [-1, +1] 之间的数值。

        //自动生成摘要
        String text2="你睡了吗，看起来你没睡。";
        String result= HanLP.abstractiveSummarization(text2);
        System.out.println(result);

       //相似度对比
        String[][] textPairs = {
                {"看图猜一电影名", "看图猜电影"},
                {"无线路由器怎么无线上网", "无线上网卡和无线路由器怎么用"},
                {"北京到上海的动车票", "上海到北京的动车票"}
        };
        List<Double> similarityScoresList = HanLP.semanticTextualSimilarity(textPairs);
        double[] similarityScores = similarityScoresList.stream().mapToDouble(Double::doubleValue).toArray();
        for (double score : similarityScores) {
            System.out.println(score);
        }

        //文本分类
        String text3="改了好几次，感觉终于可以确定了。\n" +
                "这次的真丝是做了古董感的米金色染色，法蕾也做了同样的颜色。\n" +
                "真丝软糯的手感和温柔的光泽感，在即将结束的冬天，显得格外的美好。";

        String result2=HanLP.textClassification(text3,"news_zh");
        System.out.println(result2);

        //
        Map<String,Double> map=HanLP.keyphraseExtraction("自然语言处理是一门博大精深的学科，掌握理论才能发挥出HanLP的全部性能。《自然语言处理入门》是一本配套HanLP的NLP入门书，助你零起点上手自然语言处理。",3);
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        Map<String,String> map1 = new HashMap<>();
        DecimalFormat df = new DecimalFormat("0.00");
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            Double percentage = entry.getValue() * 100;
            System.out.println(entry.getKey() + ":" + df.format(percentage) + "%");
            map1.put(entry.getKey(), df.format(percentage) + "%");
        }

        for (Map.Entry<String, String> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
