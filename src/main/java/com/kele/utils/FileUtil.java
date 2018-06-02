package com.kele.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil implements IFileReader {
    public String textInOneLine(String filePath) throws IOException {
        StringBuilder temp = new StringBuilder();
        File file = new File(filePath);
        FileReader reader = new FileReader(file);
        BufferedReader bfReader = null;
        String line;
        bfReader = new BufferedReader(reader);
        line = bfReader.readLine();
        while (line != null){
            temp.append(line);
            line = bfReader.readLine();
        }
        return temp.toString();
    }


}
