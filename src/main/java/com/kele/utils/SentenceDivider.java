package com.kele.utils;

import java.util.LinkedList;
import java.util.List;

public class SentenceDivider {
    public SentenceDivider(){}


    public String[] divideToSentence(String content){
        if(content == null) return new String[0];
        content = preProcess(content);
        StringBuilder cache = new StringBuilder();
        String[] temp = content.split("\\.");
        return temp;// 暂时测试用
    }

    public List<String> divideToSegment(String content, int sizeLimit){
        if(content == null) return new LinkedList<String>();
        List<String> result = new LinkedList<String>();
        StringBuilder cache = new StringBuilder();
        String[] sentences = divideToSentence(content);
        int curSize = 0;
        for(String sentence : sentences){
            if(curSize + sentence.length() < sizeLimit){
                cache.append(sentence);
                cache.append('.');
                curSize += sentence.length();
            }
            else {
                result.add(cache.toString());
                cache = new StringBuilder();
                curSize = sentence.length();
                cache.append(sentence);
                cache.append('.');
            }
        }
        if(curSize > 0) result.add(cache.toString());
        return result;
    }

    public String preProcess(String content){
        // 去掉换行符
        StringBuilder temp = new StringBuilder();
        content = content.replaceAll("-\n", "");
        for (int i = 0; i < content.length(); i++){
            if(content.charAt(i) != '\n')
                temp.append(content.charAt(i));
        }
        return temp.toString();
    }
}
