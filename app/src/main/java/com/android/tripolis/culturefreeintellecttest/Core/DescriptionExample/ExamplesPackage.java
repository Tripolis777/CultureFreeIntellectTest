package com.android.tripolis.culturefreeintellecttest.Core.DescriptionExample;

import android.widget.ImageView;

import com.android.tripolis.culturefreeintellecttest.Realm.Description.ExampleEntryPackage;

import java.util.ArrayList;

/**
 * Created by v.karyagin on 21.11.2017.
 */

public class ExamplesPackage {

    private ArrayList<SimpleExample> simpleExamples;
    private ArrayList<ExampleImage> exampleImages;

    private ArrayList<ExampleEntryPackage.PackageItemInfo> itemInfos;

    public ExamplesPackage() {
        this.exampleImages = new ArrayList<>();
        this.simpleExamples = new ArrayList<>();
        this.itemInfos = new ArrayList<>();
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

    public void setItemInfos(ArrayList<ExampleEntryPackage.PackageItemInfo> itemInfos) {
        this.itemInfos = itemInfos;
    }

}
