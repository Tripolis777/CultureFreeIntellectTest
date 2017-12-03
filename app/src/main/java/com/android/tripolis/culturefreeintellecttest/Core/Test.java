package com.android.tripolis.culturefreeintellecttest.Core;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.android.tripolis.culturefreeintellecttest.Fragment.CFITFragment;
import com.android.tripolis.culturefreeintellecttest.Fragment.SubtestInfoFragment;
import com.android.tripolis.culturefreeintellecttest.Realm.DescriptionEntry;
import com.android.tripolis.culturefreeintellecttest.Realm.TestEntry;

/**
 * Created by tripo on 12/2/2017.
 */

public class Test {

    private static final String FRAGMENT_DESCRIPTION_TAG = "test_description";

    private final Context context;
    private final TestEntry testEntry;
    private int currentSubtestNum;

    private SubtestManager subtestManager;

    public Test(@NonNull final Context context, @NonNull TestEntry testEntry) {
        this.context = context;
        this.testEntry = testEntry;
        this.currentSubtestNum = 0;

        this.subtestManager = new SubtestManager(context, testEntry);
    }

    public CFITFragment getStartFragment() {

        if (isHaveTestDescriprion())
            return getTestDescriptionFragment();

        return null;
    }

    public CFITFragment getTestDescriptionFragment() {

        DescriptionEntry descriptionEntry = testEntry.getTestDescription();
        Description description = new Description(descriptionEntry, context);

        CFITFragment fragment = SubtestInfoFragment.newInstance(description, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Test.this.start();
            }
        });

        fragment.setFragmentTag(FRAGMENT_DESCRIPTION_TAG);
        return fragment;
    }

    public boolean isHaveTestDescriprion() {
        return testEntry.getTestDescription() != null;
    }

    public void start() {
        currentSubtestNum++;
     //   Subtest subtest = subtestManager.getSubtest(currentSubtestNum);
    }

}
