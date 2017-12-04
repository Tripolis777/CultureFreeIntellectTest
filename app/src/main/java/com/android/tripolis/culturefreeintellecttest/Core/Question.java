package com.android.tripolis.culturefreeintellecttest.Core;

import android.support.v4.app.Fragment;

import com.android.tripolis.culturefreeintellecttest.Core.Tools.ImageCutter;
import com.android.tripolis.culturefreeintellecttest.Fragment.CFIT.FirstSubtestQuestionFragment;
import com.android.tripolis.culturefreeintellecttest.Fragment.CFITFragment;
import com.android.tripolis.culturefreeintellecttest.Realm.QuestionEntry;

/**
 * Created by tripo on 11/4/2017.
 */

public class Question {

    private static final int TYPE_FIRST_SUBTEST_QUESTION = 1;

    private int questionImagesCount;
    private int answerImagesCount;
    private ImageCutter questionImages;
    private ImageCutter answerImages;

    private final QuestionEntry questionEntry;

    public Question(QuestionEntry entry) { //, ImageCutter imageCutter) {
        questionEntry = entry;
    }

    public int getQuestionImagesCount() {
        return questionImagesCount;
    }

    public int getAnswerImagesCount() {
        return answerImagesCount;
    }

    public CFITFragment getQuestionFragment() {
        switch (questionEntry.getType()) {
            case TYPE_FIRST_SUBTEST_QUESTION:
                return FirstSubtestQuestionFragment.newInstance(this);
            default:
                return null;
        }
    }
}
