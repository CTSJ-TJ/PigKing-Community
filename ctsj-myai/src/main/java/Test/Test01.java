package Test;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;

import java.util.List;

public class Test01 {
    public static void main(String[] args) {
        String text = "我爱自然语言处理技术！";
        List<Term> termList = HanLP.segment(text);
        System.out.println(termList);
        String document = "这是一段很长的文本，包含了很多重要的信息。";
        int maxSummaryLength = 50;  // 摘要的最大长度
        String summary = HanLP.extractSummary(document, maxSummaryLength).toString();
        System.out.println(summary);
    }
}
