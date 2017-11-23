package com.android.tripolis.culturefreeintellecttest.Core.DescriptionExample;

import android.content.Context;

import com.android.tripolis.culturefreeintellecttest.Realm.Description.ExampleEntry;
import com.android.tripolis.culturefreeintellecttest.Realm.Description.ExampleEntryImage;
import com.android.tripolis.culturefreeintellecttest.Realm.Description.ExampleEntryPackage;

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

    public static ExamplesPackage convertExampleEntryPackage(ExampleEntryPackage exampleEntryPackage) {
        ExamplesPackage examplesPackage = new ExamplesPackage();
        return examplesPackage;
    }

}
