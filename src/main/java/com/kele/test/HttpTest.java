package com.kele.test;

import okhttp3.*;
import org.junit.Test;
import java.io.IOException;
public class HttpTest {


    public void getTest(){
        Request googleRequest = new Request.Builder()
                .url("https://translate.google.cn/#zh-CN/en/农业国家")
                .build();
        OkHttpClient client = new OkHttpClient();
        try {
            client.newCall(googleRequest).enqueue(new Callback() {
                public void onFailure(Call call, IOException e) {
                    System.out.println("Call failed.");
                }

                public void onResponse(Call call, Response response) throws IOException {
                    int code = response.code();
                    System.out.println(code);
                    if(200 == response.code()){

                    }
                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println("Quit");
        }

    }
}
