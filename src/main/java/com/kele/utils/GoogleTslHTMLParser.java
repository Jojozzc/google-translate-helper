package com.kele.utils;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleTslHTMLParser {
    public String getTranslateResult(String html){
        String result = "";
        Document doc = new Document(html);
        Element body = doc.body();
        return result;
    }
}
