package com.android.tripolis.culturefreeintellecttest.Core;

import android.graphics.Bitmap;

import com.android.tripolis.culturefreeintellecttest.Core.Tools.ImageCutter;
import com.android.tripolis.culturefreeintellecttest.Realm.AnswerEntry;
import com.android.tripolis.culturefreeintellecttest.Realm.ImageAssetEntry;
import com.android.tripolis.culturefreeintellecttest.Realm.QuestionEntry;

/**
 * Created by tripo on 12/14/2017.
 */

public class Answer {

    private final AssetManager assetManager;
    private final AnswerEntry answerEntry;
    private final QuestionEntry questionEntry;
    private ImageCutter imageCutter;

    public Answer(AnswerEntry answerEntry, QuestionEntry questionEntry, AssetManager assetManager) {
        this.answerEntry = answerEntry;
        this.assetManager = assetManager;
        this.questionEntry = questionEntry;
    }

    public Bitmap getAnswerImage() {
        if (imageCutter == null) {
            ImageAssetEntry assetEntry = answerEntry.getImageAssetEntry();
            Bitmap asset = assetManager.getAsset(assetEntry.getResourceName());
            imageCutter = new ImageCutter(asset, assetEntry.getRowsCnt(), assetEntry.getColumnsCnt());
        }

        return imageCutter.getPack(1, questionEntry.getNum() * answerEntry.getNum())[0];
    }

}
