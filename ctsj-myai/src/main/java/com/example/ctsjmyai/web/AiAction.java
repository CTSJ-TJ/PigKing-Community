package com.example.ctsjmyai.web;

import com.hankcs.hanlp.restful.HanLPClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("myai")
public class AiAction {

    HanLPClient HanLP = new HanLPClient("https://www.hanlp.com/api",
            "NTE4M0BiYnMuaGFubHAuY29tOmhyVW93bDZTMm9Qd3NpWnQ=");

    @RequestMapping("emotion")
    public String emotion(@RequestParam("texts") String texts) throws IOException {
       double sentiment = HanLP.sentimentAnalysis(texts);
       String result = String.format("%.3f", sentiment);
       System.out.println(result);
       return result;
    }

    @RequestMapping("abstract")
    public String abstracted(@RequestParam("texts") String texts) throws IOException {
        String result= HanLP.abstractiveSummarization(texts);
        System.out.println(result);
        return result;
    }

    @RequestMapping("keyword")
    public Map keyword(@RequestParam("texts") String texts,@RequestParam("math") String value) throws IOException {
        Map<String,Double> map=HanLP.keyphraseExtraction(texts, Integer.parseInt(value));
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
        return map1;
    }




}
