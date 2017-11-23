package com.android.tripolis.culturefreeintellecttest.Core;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.android.tripolis.culturefreeintellecttest.Core.DescriptionExample.Example;
import com.android.tripolis.culturefreeintellecttest.Core.DescriptionExample.ExampleBuilder;
import com.android.tripolis.culturefreeintellecttest.Core.DescriptionExample.ExampleImage;
import com.android.tripolis.culturefreeintellecttest.Fragment.CFIT.DescriptionWithImageFragment;
import com.android.tripolis.culturefreeintellecttest.Realm.Description.ExampleEntry;
import com.android.tripolis.culturefreeintellecttest.Realm.Description.ExampleEntryPackage;
import com.android.tripolis.culturefreeintellecttest.Realm.DescriptionEntry;

/**
 * Created by tripo on 11/4/2017.
 */

public class Description {

    private final DescriptionEntry descriptionEntry;
    private final Context context;

    private DescriptionEntry.DescriptionType descriptionType;
    private int pagesCount;
    private Example[] examples;

    private String testName;
    private String testDescription;

    private FragmentFactory<Description> fragmentFactory;

    public Description (DescriptionEntry descriptionEntry, @NonNull final Context context) {
        this.descriptionEntry = descriptionEntry;
        this.context = context;

        final Resources res = context.getResources();
        final String packageName = context.getPackageName();
        DescriptionEntry.DescriptionEntryData descriptionData = descriptionEntry.getDescriptionData();

        String testNameKey = descriptionData.getTestNameKey();
        testName = res.getString(res.getIdentifier(testNameKey, "string", packageName));

        String testInfoKey = descriptionData.getTestInfoKey();
        testDescription = res.getString(res.getIdentifier(testInfoKey, "string", packageName));

        pagesCount = descriptionData.getExamplesCount();

        examples = new Example[pagesCount];
        ExampleEntryPackage exampleEntries = descriptionData.getExamples();
        examples = ExampleBuilder.createExample(exampleEntries, context);

    }

//    public DescriptionEntry.DescriptionType getDescriptionType() {
//        return descriptionEntry.getType();
//    }

    public FragmentFactory<Description> getFragmentFactory() {
        return fragmentFactory;
    }

    public Fragment getPageFragment(int page) {
        Fragment fragment = null;

        Example example = examples[page];
        switch (example.getType()) {
            case SIMPLE:
                // TODO: Create SIMPLE Description type fragment
            case WITH_IMAGES:
                ExampleImage exampleImage = (ExampleImage) example;
                fragment = DescriptionWithImageFragment.newInstance(exampleImage);
            default:
                // TODO: Create default behavior
        }

        return fragment;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public Example getExample(int page) {
        if (page > examples.length)
            return null;

        return examples[page];
    }

    public String getTestName() {
        return testName;
    }

    public String getTestDescription() {
        return testDescription;
    }
}
