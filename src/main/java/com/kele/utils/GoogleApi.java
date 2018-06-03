package com.kele.utils;

import com.kele.model.Browser;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.*;
import java.net.URLEncoder;

public class GoogleApi {
    private ScriptEngine engine;
    private static final String GETTTKPATH = "/media/zou/Code/ubuntu/googleTranslationHelper/src/getttk.js";
    private ScriptEngineManager scriptEngineManager;
    private Browser browser;
    public GoogleApi(){
        scriptEngineManager = new ScriptEngineManager();
        engine = scriptEngineManager.getEngineByName("javascript");
        Reader reader;
        browser = new Browser();
        try{
            File jsSource = new File(GETTTKPATH);
            InputStream inputStream = new FileInputStream(jsSource);
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            reader = new InputStreamReader(inputStream, "UTF-8");
            engine.eval(reader);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getTKK(){
//        browser.setUrl("https://translate.google.cn/");
        String url = "https://translate.google.cn/";
        try{
            String result = browser.executeGetWithProxy(url);
//            if(StringUtils.isNotBlank(result)){
            if(!(result == null || result.length() == 0)){
                if(result.indexOf("TKK") > -1){
                    String tkk = result.split("TKK")[1];
                    tkk = tkk.split("\\)\\;")[0];
                    tkk = tkk + ");";
                    tkk = tkk.substring(1, tkk.length());
                    ScriptEngineManager manager = new ScriptEngineManager();
                    ScriptEngine engine = manager.getEngineByName("javascript");
                    return (String) engine.eval(tkk);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String getTK(String word, String tkk){
        String result = null;
        try{
            if (engine instanceof Invocable){
                Invocable invocable = (Invocable) engine;
                result = (String) invocable.invokeFunction("tk", new Object[]{word, tkk});
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public String translate(String word, String from, String to){

        if(word == null || word.length() == 0){
            return null;
        }
        System.out.println("要翻译的内容：" + word);
        String _tkk = getTKK();
        if(_tkk == null || _tkk.length() == 0){
            return null;
        }
        String _tk = getTK(word, _tkk);
        try{
            word = URLEncoder.encode(word, "UTF-8");
        }catch(Exception e){
            e.printStackTrace();
        }
        StringBuffer buffer = new StringBuffer("https://translate.google.cn/translate_a/single?client=t");
        buffer.append("&sl=" + from);
        buffer.append("&tl=" + to);
        buffer.append("&hl=zh-CN&dt=at&dt=bd&dt=ex&dt=ld&dt=md&dt=qca&dt=rw&dt=rm&dt=ss&dt=t&ie=UTF-8&oe=UTF-8&source=btn&kc=0");
        buffer.append("&tk=" + _tk);
        buffer.append("&q=" + word);
        System.out.println(buffer.toString());
        System.out.println("使用服务器请求");
        browser.setUrl(buffer.toString());
        try{
            String result = browser.executeGetWithProxy(buffer.toString());
            System.out.println("服务器返回json:");
            System.out.println(result);
//            JSONArray array = (JSONArray) JSONArray.parse(result);
//            JSONArray r_array = array.getJSONArray(0);
//            StringBuffer r_buffer = new StringBuffer();
//            for(int i = 0; i < r_array.size(); i++){
//                String _r = r_array.getJSONArray(i).getString(0);
//                if(!(_r == null || _r.length() == 0)){
//                    r_buffer.append(_r);
//                }
//            }
//            return r_buffer.toString();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
