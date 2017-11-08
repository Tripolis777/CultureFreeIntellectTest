package com.android.tripolis.culturefreeintellecttest.Core;

/**
 * Created by tripo on 11/4/2017.
 */

public class QuestionManager {

    private FragmentFactory<Question> fragmentFactory;

    private int questionsCount;

    public QuestionManager(FragmentFactory<Question> fragmentFactory) {
        this.fragmentFactory = fragmentFactory;
    }

    public FragmentFactory<Question> getFragmentFactory() {
        return fragmentFactory;
    }

    public Question getQuestion(int questionNum) {
        return null;
    }

    public String getQuestionTitle(int position) {
        return null;
    }

    public int getQuestionsCount() {
        return questionsCount;
    }

}
