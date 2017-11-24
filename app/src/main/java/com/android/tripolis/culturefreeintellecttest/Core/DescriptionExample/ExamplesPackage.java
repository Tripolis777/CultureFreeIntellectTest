package com.android.tripolis.culturefreeintellecttest.Core.DescriptionExample;

import android.support.annotation.Nullable;

import com.android.tripolis.culturefreeintellecttest.Realm.Description.ExampleEntryPackage;

import java.util.ArrayList;
import java.util.List;

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

    public ExampleEntryPackage.PackageItemInfo getItemInfo(int index) {
        return this.itemInfos.get(index);
    }

    @Nullable
    public Example getExample(int index) {
        ExampleEntryPackage.PackageItemInfo info = getItemInfo(index);
        switch(info.type) {
            case SIMPLE:
                return getSimpleExample(info.num);
            case WITH_IMAGES:
                return getExampleImage(info.num);
            default:
                return null;
        }
    }

    @Nullable
    public SimpleExample getSimpleExample(int index) {
        if (isWrongIndex(simpleExamples, index))
            return null;

        return simpleExamples.get(index);
    }

    @Nullable
    public ExampleImage getExampleImage(int index) {
        if (isWrongIndex(exampleImages, index))
            return null;

        return exampleImages.get(index);
    }

    private boolean isWrongIndex(List list, int index) {
        return list.isEmpty() || list.size() < index || index < 0;
    }
}
