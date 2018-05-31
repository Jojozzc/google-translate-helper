package com.kele.main;

import com.kele.test.HttpTest;
import com.kele.utils.URLHelper;

public class Main {
    public static void main(String[] args){
        final HttpTest httpTest = new HttpTest();
        Thread httpThread = new Thread(new Runnable() {
            public void run() {
                httpTest.getTest();
            }
        });
        httpThread.start();
    }
}
