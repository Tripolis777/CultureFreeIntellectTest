package com.android.tripolis.culturefreeintellecttest.Database.Entries;

import android.provider.BaseColumns;
import android.support.annotation.Nullable;

/**
 * Created by tripo on 11/4/2017.
 */

public class QuestionEntry extends DatabaseEntry {

    public static abstract class QuestionSchema implements BaseColumns {
        public static final String TABLE_NAME = "question";
        public static final String COLUMN_NAME_SUBTEST = "subtest";
        public static final String COLUMN_NAME_TEST_NUM = "test_num";
        public static final String COLUMN_NAME_ANSWER = "answer";
        public static final String COLUMN_NAME_TYPE = "type";
        public static final String COLUMN_NAME_IMAGE_ASSET = "image_asset";

        public static final String JOIN_TEST_TABLE = "";
        public static final String JOIN_ANSWER_TABLE = "INNER JOIN answer ON answer._id = question.answer";
        public static final String JOIN_IMAGE_ASSET_TABLE = "INNER JOIN image_asset ON image_asset._id = question.image_asset";
    }

    private int subtestIdx;
    private int testNum;
    private int answerIdx;
    private int type;
    private int imageAssetIdx;

    private AnswerEntry answerEntry;
    private ImageAssetEntry imageAssetEntry;

    public int getSubtestIdx() {
        return subtestIdx;
    }

    public int getTestNum() {
        return testNum;
    }

    public int getAnswerIdx() {
        return answerIdx;
    }

    public int getType() {
        return type;
    }

    public int getImageAssetIdx() {
        return imageAssetIdx;
    }

    @Nullable
    public AnswerEntry getAnswerEntry() {
        return answerEntry;
    }

    @Nullable
    public ImageAssetEntry getImageAssetEntry() {
        return imageAssetEntry;
    }

    public void setSubtestIdx(int subtestIdx) {
        this.subtestIdx = subtestIdx;
    }

    public void setTestNum(int testNum) {
        this.testNum = testNum;
    }

    public void setAnswerIdx(int answerIdx) {
        this.answerIdx = answerIdx;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setImageAssetIdx(int imageAssetIdx) {
        this.imageAssetIdx = imageAssetIdx;
    }

    public void setAnswerEntry(AnswerEntry answerEntry) {
        this.answerEntry = answerEntry;
    }

    public void setImageAssetEntry(ImageAssetEntry imageAssetEntry) {
        this.imageAssetEntry = imageAssetEntry;
    }
}
