package com.kele.test;

import com.kele.utils.PDFUtil;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Test;

public class PDFUtilTest {
    @Test
    public void readFileText(){
        String filePath = "/media/zou/Data/文档/毕设文章/multi-task+learning.pdf";
        PDFUtil pdfUtil = new PDFUtil();
        try {
            System.out.println(filePath);
            System.out.println(pdfUtil.textInOneLine(filePath).substring(0, 600));
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
