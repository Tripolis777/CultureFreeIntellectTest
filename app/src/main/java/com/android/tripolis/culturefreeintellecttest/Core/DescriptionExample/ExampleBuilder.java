package com.android.tripolis.culturefreeintellecttest.Core.DescriptionExample;

import android.content.Context;

import com.android.tripolis.culturefreeintellecttest.Realm.Description.ExampleEntry;
import com.android.tripolis.culturefreeintellecttest.Realm.Description.ExampleEntryImage;

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
                example = new ExampleImage((ExampleEntryImage) entry, context);
        }

        return example;
    }

}
