package com.android.tripolis.culturefreeintellecttest.Core;

import com.android.tripolis.culturefreeintellecttest.Core.Database.Entries.QuestionEntry;
import com.android.tripolis.culturefreeintellecttest.Core.Tools.ImageCutter;

/**
 * Created by tripo on 11/4/2017.
 */

public class Question {

    private int questionImagesCount;
    private int answerImagesCount;
    private ImageCutter questionImages;
    private ImageCutter answerImages;

    public Question(QuestionEntry entry, ImageCutter imageCutter) {

    }

    public int getQuestionImagesCount() {
        return questionImagesCount;
    }

    public int getAnswerImagesCount() {
        return answerImagesCount;
    }
}
