package com.kele.utils;

public class OkHttpUtil {
    private static OkHttpUtil instances = new OkHttpUtil();
    private OkHttpUtil(){}

    public static OkHttpUtil getInstances() {
        return instances;
    }




}
