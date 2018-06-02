package com.kele.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class JsoupTest {

    public void jsoupTest()throws Exception{
        Document doc
                = Jsoup.connect("https://translate.google.cn/#zh-CN/en/测试用例").get();
        System.out.println(doc.title());

//        Elements elements = doc.select();


    }
    public void demo1(){
        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>";
        Document doc = Jsoup.parse(html);
        Element body = doc.body();
        System.out.println(body.toString());
    }

}
