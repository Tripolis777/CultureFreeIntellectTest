package com.android.tripolis.culturefreeintellecttest.Core;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by tripo on 11/4/2017.
 */

public class QuestionManager {

    private FragmentFactory<Question> fragmentFactory;
    private ArrayList<Question> questions;

    private int questionsCount;

    public QuestionManager(FragmentFactory<Question> fragmentFactory) {
        this.fragmentFactory = fragmentFactory;
    }

    public FragmentFactory<Question> getFragmentFactory() {
        return fragmentFactory;
    }

    public Question getQuestion(int questionNum) {
        if (questionNum > questions.size()) {
            Log.e("[QuestionManager]", "Cant get question. Question num biggest questions count.");
            throw new NullPointerException();    // TODO: replace to self exception
        }

        return questions.get(questionNum);
    }

    public String getQuestionTitle(int position) {
        return null;
    }

    public int getQuestionsCount() {
        return questionsCount;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

}
