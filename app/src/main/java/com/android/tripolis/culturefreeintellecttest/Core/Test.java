package com.android.tripolis.culturefreeintellecttest.Core;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.android.tripolis.culturefreeintellecttest.Realm.TestEntry;

/**
 * Created by tripo on 12/2/2017.
 */

public class Test {

    private final Context context;
    private final TestEntry testEntry;

    private SubtestManager subtestManager;

    public Test(@NonNull final Context context, @NonNull TestEntry testEntry) {
        this.context = context;
        this.testEntry = testEntry;

        this.subtestManager = new SubtestManager(context, testEntry);
    }

    public Fragment getStartFragment() {
        return null;
    }

    @Nullable
    public Fragment getTestDescriptionFragment() {
        return null;
    }

}
