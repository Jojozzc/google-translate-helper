package com.kele.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PDFUtil implements IFileReader{
    public String textInOneLine(String filePath) throws IOException {
        return textInOneLineFromPdf(filePath);
    }
    private String textInOneLineFromPdf(String filePath)throws IOException{
        File file = new File(filePath);
        PDDocument document = PDDocument.load(file);
        PDFTextStripper textStripper = new PDFTextStripper();
        String content = textStripper.getText(document);
        return content;
    }
}
