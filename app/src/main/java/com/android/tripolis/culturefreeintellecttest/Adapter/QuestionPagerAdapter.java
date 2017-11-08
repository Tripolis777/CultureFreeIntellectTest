package com.android.tripolis.culturefreeintellecttest.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.android.tripolis.culturefreeintellecttest.Core.QuestionManager;

/**
 * Created by tripo on 11/4/2017.
 */

public class QuestionPagerAdapter extends FragmentPagerAdapter {

    private final QuestionManager questionManager;

    public QuestionPagerAdapter(FragmentManager fm, QuestionManager questionManager) {
        super(fm);
        this.questionManager = questionManager;
    }

    @Override
    public Fragment getItem(int position) {
        return questionManager.getFragmentFactory().createFragment(questionManager.getQuestion(position));
    }

    @Override
    public int getCount() {
        return questionManager.getQuestionsCount();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return questionManager.getQuestionTitle(position);
    }
}
