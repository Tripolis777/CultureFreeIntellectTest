package com.android.tripolis.culturefreeintellecttest.Realm;

import android.support.annotation.Nullable;

import io.realm.RealmObject;

/**
 * Created by tripo on 11/14/2017.
 */

public class QuestionEntry extends RealmObject {

    private int subtestIdx;
    private int type;

    private TestEntry test;
    private AnswerEntry answerEntry;
    private ImageAssetEntry imageAssetEntry;

    public int getSubtestIdx() {
        return subtestIdx;
    }

    public TestEntry getTest() {
        return test;
    }

    public int getType() {
        return type;
    }

    public AnswerEntry getAnswerEntry() {
        return answerEntry;
    }

    public ImageAssetEntry getImageAssetEntry() {
        return imageAssetEntry;
    }

    public void setSubtestIdx(int subtestIdx) {
        this.subtestIdx = subtestIdx;
    }

    public void setTest(TestEntry test) {
        this.test = test;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setAnswerEntry(AnswerEntry answerEntry) {
        this.answerEntry = answerEntry;
    }

    public void setImageAssetEntry(ImageAssetEntry imageAssetEntry) {
        this.imageAssetEntry = imageAssetEntry;
    }

}
