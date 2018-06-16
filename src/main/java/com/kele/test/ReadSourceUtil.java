package com.kele.test;

import java.util.Scanner;

public class ReadSourceUtil {
    public static String readWholeTextFromTerminal(){
        String endMark = "";
        Scanner in = new Scanner(System.in);
        StringBuilder temp = new StringBuilder();
        String line = in.nextLine();
        while (!line.equals(endMark)){
            temp.append(line);
            line = in.nextLine();
        }
        return temp.toString();
    }
}
