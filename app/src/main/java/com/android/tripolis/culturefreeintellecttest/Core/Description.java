package com.android.tripolis.culturefreeintellecttest.Core;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.android.tripolis.culturefreeintellecttest.Core.Database.Entries.DescriptionEntry;

/**
 * Created by tripo on 11/4/2017.
 */

public class Description {
    public enum DescriptionType { SIMPLE, WITH_IMAGES }

    private final DescriptionEntry descriptionEntry;
    private final Context context;

    private DescriptionType descriptionType;
    private int pagesCount;
    private String[] exampleTitles;

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

        exampleTitles = new String[pagesCount];
        String[] exampleTitleKeys = descriptionData.getExamplesTitleKeys();
        for (int i = 0; i < pagesCount; i++) {
            exampleTitles[i] = res.getString(res.getIdentifier(exampleTitleKeys[i], "string", packageName));
        }
    }

    public void setDescriptionType(DescriptionType type) {
        this.descriptionType = type;
    }

    public DescriptionType getDescriptionType() {
        return descriptionType;
    }

    public FragmentFactory<Description> getFragmentFactory() {
        return fragmentFactory;
    }

    public Fragment getPageFragment(int page) {
        return null;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public String getTitle(int page) {
        if (page > exampleTitles.length)
            return null;

        return exampleTitles[page];
    }

    public String getTestName() {
        return testName;
    }

    public String getTestDescription() {
        return testDescription;
    }
}
