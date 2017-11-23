package com.android.tripolis.culturefreeintellecttest.Core.DescriptionExample;

import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by v.karyagin on 21.11.2017.
 */

public class ExamplesPackage {

    private ArrayList<SimpleExample> simpleExamples;
    private ArrayList<ExampleImage> exampleImages;

    public ExamplesPackage() {
        this.exampleImages = new ArrayList<>();
        this.simpleExamples = new ArrayList<>();
    }

    public void put(SimpleExample simpleExample) {
        this.simpleExamples.add(simpleExample);
    }

    public void put(ExampleImage exampleImage) {
        this.exampleImages.add(exampleImage);
    }

    public ArrayList<SimpleExample> getSimpleExamples() {
        return simpleExamples;
    }

    public ArrayList<ExampleImage> getExampleImages() {
        return exampleImages;
    }
}
