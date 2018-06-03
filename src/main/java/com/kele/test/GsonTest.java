package com.kele.test;

import com.google.gson.Gson;
import org.junit.Test;

public class GsonTest {
    @Test
    public void arrayJson(){
        Gson gson = new Gson();
        String json = "[[[\"Chinese people\",\"中国人\",null,null,1],[null,null,null,\"Zhōngguó rén\"]],null,\"zh-CN\",null,null,[[\"中国人\",null,[[\"Chinese people\",1000,true,false]],[[0,3]],\"中国人\",0,0]],0.98251754,null,[[\"zh-CN\"],null,[0.98251754],[\"zh-CN\"]],null,null,null,null,null,[[\"中国\",\"中\",\"人\",\"国\"]]]";
        String[] resutlt = gson.fromJson(json, String[].class);

    }
}
