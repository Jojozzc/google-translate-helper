package com.kele.test;

import com.kele.utils.URLHelper;
import org.junit.Test;

public class URLHelperTest {
    @Test
    public void translateUrlTest(){
        URLHelper helper = new URLHelper();
        String source = "天池";
        String result = helper.getTranslateUrl(source, URLHelper.CHINESE, URLHelper.ENGLISH);
        System.out.println(result);
    }
}
