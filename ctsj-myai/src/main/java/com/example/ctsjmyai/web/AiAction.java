package com.example.ctsjmyai.web;

import com.hankcs.hanlp.restful.HanLPClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
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


}
