package com.kele.test;

import com.kele.utils.GoogleApi;
import org.junit.Test;

public class GoogleApiTest {


    public void translateTest(){
        System.out.println("start translating");
        GoogleApi googleApi = new GoogleApi();
        googleApi.translate("Convolutional networks trained on large supervised\n" +
                "dataset produce visual features which form the basis for\n" +
                "the state-of-the-art in many computer-vision problems. Fur-\n" +
                "ther improvements of these visual features will likely require\n" +
                "even larger manually labeled data sets, which severely lim-\n" +
                "its the pace at which progress can be made. In this pa-\n" +
                "per, we explore the potential of leveraging massive, weakly-\n" +
                "labeled image collections for learning good visual features.\n" +
                "We train convolutional networks on a dataset of 100 million\n" +
                "Flickr photos and captions, and show that these networks\n" +
                "produce features that perform well in a range of vision prob-\n" +
                "lems. We also show that the networks appropriately capture\n" +
                "word similarity, and learn correspondences between differ-\n" +
                "ent languages.", "", "zh");

    }
}
