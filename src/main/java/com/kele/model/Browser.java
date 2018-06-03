package com.kele.model;

import okhttp3.*;
import java.net.InetSocketAddress;
import java.net.Proxy;

public class Browser {
    public Proxy proxy;
    public String url;

    public String getUrl()
    {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setProxy(String ip, Integer port) {
        this.proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port.intValue()));
    }

    public String executeGetWithProxy(String url)throws Exception{
        String result = "";
        OkHttpClient client = new OkHttpClient.Builder()
                .proxy(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(NetConfig.PROXY_HOST_IP, NetConfig.PROXY_HOST_PORT)))
                .build();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        result = response.body().string();
        return result;
    }

    public String executeGet(String url)
            throws Exception {
        String result = "";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        result = response.body().string();
        return result;

//            client.newCall(request).enqueue(new Callback() {
//                @Override
//                public void onFailure(Call call, IOException e) {
//                    e.printStackTrace();
//                }
//
//                @Override
//                public void onResponse(Call call, Response response) throws IOException {
//                    System.out.println("OK");
//                    System.out.println(response.code());
//                    System.out.println(response.body().string());
//                    temp.append(response.body().string());
////                    temp.append(response.body().string());
//                }
//            });

    }
}
