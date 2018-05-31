package com.kele.test;

import okhttp3.*;
import org.junit.Test;
import java.io.IOException;
public class HttpTest {


    public void getTest(){

        final OkHttpClient client = new OkHttpClient();
        try {

            Thread httpThread = new Thread(new Runnable() {

                public void run() {
                    try {
                        Request request = new Request.Builder()
//                .url("http://publicobject.com/helloworld.txt")
                                .url("https://translate.google.cn/#zh-CN/en/农业国家")
                                .build();
                        System.out.println("start");
                        Response response = client.newCall(request).execute();
                        System.out.println(response.code());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
            httpThread.start();
            httpThread.join();
            System.out.println("haha");

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println("Quit");
        }

    }
}
