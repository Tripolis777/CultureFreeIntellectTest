package com.android.tripolis.culturefreeintellecttest.Core;

import android.graphics.Bitmap;
import android.support.v4.app.Fragment;

import com.android.tripolis.culturefreeintellecttest.Core.Tools.ImageCutter;
import com.android.tripolis.culturefreeintellecttest.Fragment.CFIT.FirstSubtestQuestionFragment;
import com.android.tripolis.culturefreeintellecttest.Fragment.CFITFragment;
import com.android.tripolis.culturefreeintellecttest.Realm.ImageAssetEntry;
import com.android.tripolis.culturefreeintellecttest.Realm.QuestionEntry;

/**
 * Created by tripo on 11/4/2017.
 */

public class Question {

    private static final int TYPE_FIRST_SUBTEST_QUESTION = 1;

    private int questionImagesCount;
    private int answerImagesCount;
    private ImageCutter questionImages;
    private Answer[] answers;
    private ImageCutter answerImages;

    private final  AssetManager assetManager;

    private final QuestionEntry questionEntry;

    public Question(QuestionEntry entry, AssetManager assetManager) { //, ImageCutter imageCutter) {
        questionEntry = entry;
        this.assetManager = assetManager;

        initType();
    }

    private void initType() {
        switch (questionEntry.getType()) {
            case TYPE_FIRST_SUBTEST_QUESTION:
                questionImagesCount = 3;
                answerImagesCount = 5;
                break;
            default:
                questionImagesCount = 0;
                answerImagesCount = 0;
        }
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

    public Bitmap[] getQuestionImages() {
        if (questionImages == null) {
            ImageAssetEntry assetEntry = questionEntry.getImageAssetEntry();
            Bitmap asset = assetManager.getAsset(assetEntry.getResourceName());
            questionImages = new ImageCutter(asset, assetEntry.getRowsCnt(), assetEntry.getColumnsCnt());
        }

        return questionImages.getPack(questionImagesCount, questionEntry.getNum());
    }

    // TODO: replace Answer[] getAnswers()
    public Bitmap[] getAnswerImages() {
        if (answerImages == null) {
            ImageAssetEntry assetEntry = questionEntry.getAnswerEntry().getImageAssetEntry();
            Bitmap asset = assetManager.getAsset(assetEntry.getResourceName());
            answerImages = new ImageCutter(asset, assetEntry.getRowsCnt(), assetEntry.getColumnsCnt());
        }

        return answerImages.getPack(5, questionEntry.getNum());
    }
}
