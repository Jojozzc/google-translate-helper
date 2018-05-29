package com.kele.test;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;

public class HttpTest {
    @Test
    public void getTest(){
        Request request = new Request.Builder()
                .url("https://translate.google.cn/#zh-CN/en/农业国家")
                .build();
        OkHttpClient client = new OkHttpClient();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
