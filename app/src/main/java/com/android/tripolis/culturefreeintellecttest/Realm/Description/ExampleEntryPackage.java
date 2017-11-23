package com.android.tripolis.culturefreeintellecttest.Realm.Description;

import com.android.tripolis.culturefreeintellecttest.Realm.DescriptionEntry;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by v.karyagin on 21.11.2017.
 */

public class ExampleEntryPackage {

    public static class PackageItemInfo {
        public int num;
        public DescriptionEntry.DescriptionType type;

        public PackageItemInfo(int num, DescriptionEntry.DescriptionType type) {
            this.num = num;
            this.type = type;
        }
    }

    private ArrayList<ExampleEntry> exampleEntries;
    private ArrayList<ExampleEntryImage> exampleEntryImages;

    private ArrayList<PackageItemInfo> itemInfos;

    public ExampleEntryPackage() {
        this.exampleEntries = new ArrayList<>();
        this.exampleEntryImages = new ArrayList<>();

        this.itemInfos = new ArrayList<>();
    }

    public int getSizeExampleEntries() {
        return exampleEntries.size();
    }

    public int getSizeExampleEntryImages() {
        return exampleEntryImages.size();
    }

    public void put(ExampleEntry exampleEntry) {
        this.addItemInfo(new PackageItemInfo(exampleEntries.size(), exampleEntry.getType()));
        this.exampleEntries.add(exampleEntry);
    }

    public void put(ExampleEntryImage exampleEntryImage) {
        this.addItemInfo(new PackageItemInfo(exampleEntryImages.size(), exampleEntryImage.getType()));
        this.exampleEntryImages.add(exampleEntryImage);
    }

    public ArrayList<ExampleEntry> getExampleEntries() {
        return this.exampleEntries;
    }

    public ArrayList<ExampleEntryImage> getExampleEntryImages() {
        return this.exampleEntryImages;
    }

    public PackageItemInfo getInfo(int index) {
        return itemInfos.get(index);
    }

    public ArrayList<PackageItemInfo> getItemInfos(){
        return this.itemInfos;
    }

    private void addItemInfo(PackageItemInfo info) {
        this.itemInfos.add(info);
    }
}
