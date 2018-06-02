package com.kele.main;

import com.kele.test.HttpTest;
import com.kele.test.JsoupTest;
import com.kele.utils.FileUtil;
import com.kele.utils.IFileReader;
import com.kele.utils.URLHelper;
import org.jsoup.Jsoup;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

public class Main {
    // 入口

    public static void main(String[] args){
        welcome();
        try{
            mainApp(args);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void welcome(){
        System.out.println("V 0.0");
        System.out.println("翻译文字总超度请不要超过1500个字");
    }
    public static void mainApp(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        String source = "";
        URLHelper helper = new URLHelper();
        IFileReader fileUtil = new FileUtil();
        while (true){
            System.out.println("选项：");
            System.out.println("1 以当前配置进行翻译");
            System.out.println("2 配置");
            System.out.println("0 退出");
            int duty = in.nextInt();
            if(duty == 0) break;
            switch (duty){
                case 1:
                    source = fileUtil.textInOneLine(AppConfig.getSourceFilePath());
                    System.out.println(helper.getTranslateUrl(source, URLHelper.CHINESE, URLHelper.ENGLISH));
                    break;
                case 2:
                    config();
                    break;
                default:break;
            }
        }
    }

    public static void config(){
        System.out.println("暂无配置选项");
    }
}
