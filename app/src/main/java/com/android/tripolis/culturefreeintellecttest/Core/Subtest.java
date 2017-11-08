package com.android.tripolis.culturefreeintellecttest.Core;

import android.support.annotation.NonNull;

/**
 * Created by tripo on 11/4/2017.
 */

public class Subtest {

    public enum SubtestState {
        DESCRIPTION, TESTING, CONCLUSION, RESULT
    }

    private int testNum;
    private int startQuestionNum;
    private int questionNum;
    private int questionsCount;
    private SubtestState state;

    private QuestionManager questionManager;
    private Description description;

    //private ImageCutter questionImage;
    //private ImageCutter answerImage;

    public Subtest(@NonNull QuestionManager questionManager, @NonNull Description description) {
        this.questionManager = questionManager;
        this.description = description;


    }

    public QuestionManager getQuestionManager() {
        return questionManager;
    }

    public FragmentFactory getQuestionFragmentFactory() {
        return questionManager.getFragmentFactory();
    }

    public void setState(SubtestState state) {
        this.state = state;
    }

    public Description getDescription() {
        return description;
    }

    public int getTestNum() {
        return testNum;
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
