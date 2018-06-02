package com.kele.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLHelper {
    public static String ENGLISH = "en";
    public static String CHINESE = "zh-CN";
    public static String TRANSLATE_URL = "https://translate.google.cn/";


    public String googleTranslateUrlWithoutNewline(String orginUrl){
        StringBuilder str = new StringBuilder();
        String[] sp = orginUrl.split("\\%0A");
        String res = "";
        for (String s : sp){
            res += s;
        }
        return res;
    }

    public String translate(String source, String from, String to){
        HttpURLConnection connection = null;
        String result = null;
        InputStream is = null;
        BufferedReader br = null;
        source = source.replaceAll("\\s", "%20");
        System.out.println(source);
        try{
            URL url = new URL(TRANSLATE_URL
                    + "#" + to + "/" + from + "/" + source);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent",
                    "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(60000);
            connection.connect();
            System.out.println(connection.getResponseCode());
            if(connection.getResponseCode() == 200){
                System.out.println("成功");
                is = connection.getInputStream();
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                StringBuffer stringBuffer = new StringBuffer();
                String line;
                while ((line = br.readLine()) != null){
                    stringBuffer.append(line);
                }
                result = stringBuffer.toString();

            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
        finally {
            if(br != null){
                try{
                    br.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            connection.disconnect();
        }
        return result;
    }
    public String getTranslateUrl(String source, String from, String to){

        StringBuilder result = new StringBuilder();
        result.append(TRANSLATE_URL);
        result.append('#');
        result.append(from);
        result.append('/');
        result.append(to);
        result.append('/');
        result.append(source.replaceAll("\\s", "%20"));
        return result.toString();
    }
    public String getTranslateUrlFromFile(String filePath, String from, String to)throws IOException{
        IFileReader reader = new FileUtil();
        String source = reader.textInOneLine(filePath);
        String resultUrl = getTranslateUrl(source, from, to);
        return resultUrl;
    }
}
