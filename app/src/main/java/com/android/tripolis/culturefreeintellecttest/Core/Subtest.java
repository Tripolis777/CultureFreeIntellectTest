package com.android.tripolis.culturefreeintellecttest.Core;

import android.content.Context;
import android.support.annotation.NonNull;

import com.android.tripolis.culturefreeintellecttest.Realm.QuestionEntry;
import com.android.tripolis.culturefreeintellecttest.Realm.SubtestEntry;

import io.realm.Realm;
import io.realm.RealmList;

/**
 * Created by tripo on 11/4/2017.
 */

public class Subtest {

    public enum SubtestState {
        DESCRIPTION, TESTING, CONCLUSION, RESULT
    }

    private int startQuestionNum;
    private int questionNum;
    private int questionsCount;
    private SubtestState state;

    private QuestionManager questionManager;
    private Description description;

    private final SubtestEntry subtestEntry;
    private final Context context;
    private final AssetManager assetManager;
    //private ImageCutter questionImage;
    //private ImageCutter answerImage;

    public Subtest(@NonNull final Context context, @NonNull SubtestEntry subtestEntry) {
        this.subtestEntry = subtestEntry;
        this.context = context;

        assetManager = new AssetManager(context);
    }

    public QuestionManager getQuestionManager() {
        if (questionManager == null)
            questionManager = new QuestionManager(subtestEntry.getQuestionsList(), assetManager);
        return questionManager;
    }

//    public FragmentFactory getQuestionFragmentFactory() {
//        return questionManager.getFragmentFactory();
//    }

    public void setState(SubtestState state) {
        this.state = state;
    }

    public Description getDescription() {
        if (description == null)
            description = new Description(subtestEntry.getSubtestDesctiprion(), context);
        return description;
    }

    public int getTestNum() {
        return subtestEntry.getIndex();
    }

    public int getQuestionsCount() {
        return questionsCount;
    }

    public int getQuestionNum() {
        return questionNum;
    }

    public SubtestState getState() {
        return state;
    }

    public int getStartQuestionNum() {
        return startQuestionNum;
    }
}
