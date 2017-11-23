package com.android.tripolis.culturefreeintellecttest.Realm.Description;

import java.util.ArrayList;

/**
 * Created by v.karyagin on 21.11.2017.
 */

public class ExampleEntryPackage {

    private ArrayList<ExampleEntry> exampleEntries;
    private ArrayList<ExampleEntryImage> exampleEntryImages;

    public ExampleEntryPackage() {
        this.exampleEntries = new ArrayList<>();
        this.exampleEntryImages = new ArrayList<>();
    }

    public int getSizeExampleEntries() {
        return exampleEntries.size();
    }

    public int getSizeExampleEntryImages() {
        return exampleEntryImages.size();
    }

    public void put(ExampleEntry exampleEntry) {
        this.exampleEntries.add(exampleEntry);
    }

    public void put(ExampleEntryImage exampleEntryImage) {
        this.exampleEntryImages.add(exampleEntryImage);
    }

    public ArrayList<ExampleEntry> getExampleEntries() {
        return this.exampleEntries;
    }

    public ArrayList<ExampleEntryImage> getExampleEntryImages() {
        return this.exampleEntryImages;
    }
}
