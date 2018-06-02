package com.kele.main;

public class AppConfig {
    private static String sourceFilePath = "";
    static {
        sourceFilePath = "/home/zou/google-translate/source.txt";
    }

    public static String getSourceFilePath() {
        return sourceFilePath;
    }

    public static void setSourceFilePath(String sourceFilePath) {
        AppConfig.sourceFilePath = sourceFilePath;
    }
}
