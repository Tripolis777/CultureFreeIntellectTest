package com.android.tripolis.culturefreeintellecttest.Core;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.android.tripolis.culturefreeintellecttest.Core.DescriptionExample.Example;
import com.android.tripolis.culturefreeintellecttest.Core.DescriptionExample.ExampleBuilder;
import com.android.tripolis.culturefreeintellecttest.Core.DescriptionExample.ExampleImage;
import com.android.tripolis.culturefreeintellecttest.Core.DescriptionExample.ExamplesPackage;
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
    private ExamplesPackage examplesPackage;

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


        examplesPackage = ExampleBuilder.convertExampleEntryPackage(descriptionData.getExamples(), context);
    }

//    public DescriptionEntry.DescriptionType getDescriptionType() {
//        return descriptionEntry.getType();
//    }

    public FragmentFactory<Description> getFragmentFactory() {
        return fragmentFactory;
    }

    @Nullable
    public Fragment getPageFragment(int page) {
        Fragment fragment = null;

        ExampleEntryPackage.PackageItemInfo exampleInfo = examplesPackage.getItemInfo(page);
        switch (exampleInfo.type) {
            case SIMPLE:
                // TODO: Create SIMPLE Description type fragment
            case WITH_IMAGES:
                ExampleImage exampleImage = examplesPackage.getExampleImage(exampleInfo.num);
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
        if (page > pagesCount)
            return null;

        return examplesPackage.getExample(page);
    }

    public String getTestName() {
        return testName;
    }

    public String getTestDescription() {
        return testDescription;
    }
}
