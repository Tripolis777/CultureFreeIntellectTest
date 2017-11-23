package com.android.tripolis.culturefreeintellecttest.Core.DescriptionExample;

import android.content.Context;

import com.android.tripolis.culturefreeintellecttest.Realm.Description.ExampleEntry;
import com.android.tripolis.culturefreeintellecttest.Realm.Description.ExampleEntryImage;
import com.android.tripolis.culturefreeintellecttest.Realm.Description.ExampleEntryPackage;

import java.util.ArrayList;

/**
 * Created by v.karyagin on 20.11.2017.
 */

public class ExampleBuilder {

    public static Example createExample(ExampleEntry entry, final Context context) {
        Example example = null;

        switch (entry.getType()) {
            case SIMPLE:
                example = new SimpleExample(entry, context);
            case WITH_IMAGES:
                ExampleEntryImage entryImage = (ExampleEntryImage) entry;
                example = new ExampleImage(entryImage, context);
        }

        return example;
    }

    public static ExamplesPackage convertExampleEntryPackage(ExampleEntryPackage exampleEntryPackage, Context context) {
        ExamplesPackage examplesPackage = new ExamplesPackage();

        ArrayList<ExampleEntry> exampleEntries = exampleEntryPackage.getExampleEntries();
        for (ExampleEntry exampleEntry : exampleEntries) {
            examplesPackage.put(new SimpleExample(exampleEntry, context));
        }

        ArrayList<ExampleEntryImage> exampleEntryImages = exampleEntryPackage.getExampleEntryImages();
        for (ExampleEntryImage exampleEntryImage : exampleEntryImages) {
            examplesPackage.put(new ExampleImage(exampleEntryImage, context));
        }

        examplesPackage.setItemInfos(exampleEntryPackage.getItemInfos());

        return examplesPackage;
    }

}
