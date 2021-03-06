package com.android.tripolis.culturefreeintellecttest.Core;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;

import com.android.tripolis.culturefreeintellecttest.Fragment.CFITFragment;
import com.android.tripolis.culturefreeintellecttest.Fragment.SubtestFragment;
import com.android.tripolis.culturefreeintellecttest.Fragment.SubtestInfoFragment;
import com.android.tripolis.culturefreeintellecttest.Realm.DescriptionEntry;
import com.android.tripolis.culturefreeintellecttest.Realm.SubtestEntry;
import com.android.tripolis.culturefreeintellecttest.Realm.TestEntry;

/**
 * Created by tripo on 12/2/2017.
 */

public class Test {
    private static final String FRAGMENT_DESCRIPTION_TAG = "test_description";

    private final Context context;
    private final TestEntry testEntry;

    private TestListener testListener;
    private int currentSubtestNum;

    private SubtestManager subtestManager;

    public Test(@NonNull final Context context, @NonNull TestEntry testEntry) {
        this.context = context;
        this.testEntry = testEntry;
        this.currentSubtestNum = 0;

        this.subtestManager = new SubtestManager(context, testEntry);
    }

    public void setTestListener(@NonNull final TestListener listener) {
        this.testListener = listener;
    }

    public void start() {
        if (testListener == null)
            return;

        testListener.onTestStart();

        if (isHaveTestDescriprion())
            testListener.onFragmentCreated(getTestDescriptionFragment());
        else {
            startSubtest(0);
        }

    }

    private CFITFragment getTestDescriptionFragment() {
        DescriptionEntry descriptionEntry = testEntry.getTestDescription();
        Description description = new Description(descriptionEntry, context);

        CFITFragment fragment = SubtestInfoFragment.newInstance(description, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSubtest(0);
            }
        });

        fragment.setFragmentTag(FRAGMENT_DESCRIPTION_TAG);
        return fragment;
    }

    public boolean isHaveTestDescriprion() {
        return testEntry.getTestDescription() != null;
    }

    private void startSubtest(int subtestNum) {
        currentSubtestNum++;
        Subtest subtest = subtestManager.getSubtest(subtestNum);

        testListener.onSubtestStart();

        if (!startSubtestDescription(subtest))
            startSubtestQuestions(subtest);
    }

    private boolean startSubtestDescription(final Subtest subtest) {
        Description description = subtest.getDescription();
        if (description == null) return false;

        CFITFragment fragment = SubtestInfoFragment.newInstance(description, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSubtestQuestions(subtest);
            }
        });
        fragment.setFragmentTag(subtestManager.getSubtestDescriptionTag(subtest.getTestNum()));
        testListener.onFragmentCreated(fragment);

        return true;
    }

    private boolean startSubtestQuestions(final Subtest subtest) {
        QuestionManager questionManager = subtest.getQuestionManager();
        if (questionManager == null) {
            // oops TODO: Exception
            Log.e("[Test]", "[startSubtestQuestions] Cannot start test. Question Manager is null.");
            return false;
        }

        CFITFragment fragment = SubtestFragment.newInstance(subtest);
        fragment.setFragmentTag(subtestManager.getSubtestDescriptionTag(subtest.getTestNum()));
        testListener.onFragmentCreated(fragment);

        return true;
    }

//    public void start() {
//        currentSubtestNum++;
//     //   Subtest subtest = subtestManager.getSubtest(currentSubtestNum);
//    }

}
