package com.kele.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class JsoupTest {

    @Test
    public void jsoupTest()throws Exception{
        Document doc
                = Jsoup.connect("https://translate.google.cn/#en/zh-CN/Convolutional%20networks%20trained%20on%20large%20superviseddataset%20produce%20visual%20features%20which%20form%20the%20basis%20forthe%20state-of-the-art%20in%20many%20computer-vision%20problems.%20Fur-ther%20improvements%20of%20these%20visual%20features%20will%20likely%20requireeven%20larger%20manually%20labeled%20data%20sets,%20which%20severely%20lim-its%20the%20pace%20at%20which%20progress%20can%20be%20made.%20In%20this%20pa-per,%20we%20explore%20the%20potential%20of%20leveraging%20massive,%20weakly-labeled%20image%20collections%20for%20learning%20good%20visual%20features.We%20train%20convolutional%20networks%20on%20a%20dataset%20of%20100%20millionFlickr%20photos%20and%20captions,%20and%20show%20that%20these%20networksproduce%20features%20that%20perform%20well%20in%20a%20range%20of%20vision%20prob-lems.%20We%20also%20show%20that%20the%20networks%20appropriately%20captureword%20similarity,%20and%20learn%20correspondences%20between%20differ-ent%20languages.").get();
        System.out.println(doc.title());
        System.out.println(doc.body().toString());

//        Elements elements = doc.select();


    }

    public void demo1(){
        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p><p>第二段<p/></body></html>";
        Document doc = Jsoup.parse(html);
        Element body = doc.body();
        Elements ps = body.select("p");
        Element p = ps.get(1);
        System.out.println(body.toString());
        System.out.println(ps.toString());
        System.out.println(p.toString());
    }

}
