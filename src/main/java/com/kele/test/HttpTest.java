package com.kele.test;

import com.kele.model.NetConfig;
import okhttp3.*;
import org.junit.Test;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

public class HttpTest {

    public void getTest(){
        Request googleRequest = new Request.Builder()
                .url("https://translate.google.cn/#en/zh-CN/" +
                        "Convolutional%20networks%20trained%20on%20large" +
                        "%20superviseddataset%20produce%20visual%20features%20which%20form%20the%20basis%20forthe" +
                        "%20state-of-the-art%20in%20many%20computer-vision%20problems.%20Fur-ther%20improvements%20" +
                        "of%20these%20visual%20features%20will%20likely%20requireeven%20larger%20manually%20labeled%20" +
                        "data%20sets,%20which%20severely%20lim-its%20the%20pace%20at%20which%20progress%20can%20be%20" +
                        "made.%20In%20this%20pa-per,%20we%20explore%20the%20potential%20of%20leveraging%20massive,%20" +
                        "weakly-labeled%20image%20collections%20for%20learning%20good%20visual%20features.We%20" +
                        "train%20convolutional%20networks%20on%20a%20dataset%20of%20100%20millionFlickr%20" +
                        "photos%20and%20captions,%20and%20show%20that%20these%20networksproduce%20features%20" +
                        "that%20perform%20well%20in%20a%20range%20of%20vision%20prob-lems.%20We%20also%20show%20" +
                        "that%20the%20networks%20appropriately%20captureword%20similarity,%20and%20learn%20" +
                        "correspondences%20between%20differ-ent%20languages.")
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
                        ResponseBody body = response.body();
                        String content = body.string();
                        System.out.println(content);

                    }
                    else System.out.println("请求异常");
                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void proxyTest(){
        OkHttpClient client = new OkHttpClient.Builder()
                .proxy(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(NetConfig.PROXY_HOST_IP, NetConfig.PROXY_HOST_PORT)))
                .build();
        String result = "";
        String url = "https://translate.google.cn/";

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        try{
            Response response = client.newCall(request).execute();
            result = response.body().string();
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
