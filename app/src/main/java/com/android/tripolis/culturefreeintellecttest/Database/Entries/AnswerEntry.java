package com.android.tripolis.culturefreeintellecttest.Database.Entries;

import android.provider.BaseColumns;
import android.support.annotation.Nullable;

/**
 * Created by tripo on 11/13/2017.
 */

public class AnswerEntry extends DatabaseEntry {

    public static abstract class AnswerSchema implements BaseColumns {
        public static final String TABLE_NAME = "answer";
        public static final String COLUMN_NAME_QUESTION = "question";
        public static final String COLUMN_NAME_IMAGE_ASSET = "image_asset";
        public static final String COLUMN_NAME_WEIGHT = "weight";
        public static final String COLUMN_NAME_TYPE = "type";     // Optional
        public static final String COLUMN_NAME_DATA = "data";     // Optional

        public static final String JOIN_QUESTION_TABLE = "INNER JOIN question ON question._id = answer.question";
        public static final String JOIN_IMAGE_ASSET_TABLE = "INNER JOIN image_asset ON image_asset._id = answer.image_asset";
    }

    private int questionIdx;
    private int imageAtlasIdx;
    private int weight;
    private int type;
    private String data;

    private QuestionEntry questionEntry;
    private ImageAssetEntry imageAssetEntry;

    public int getQuestionIdx() {
        return questionIdx;
    }

    public int getImageAtlasIdx() {
        return imageAtlasIdx;
    }

    public int getWeight() {
        return weight;
    }

    public int getType() {
        return type;
    }

    public String getDataString() {
        return data;
    }

    @Nullable
    public QuestionEntry getQuestionEntry() {
        return questionEntry;
    }

    @Nullable
    public ImageAssetEntry getImageAssetEntry() {
        return imageAssetEntry;
    }

    public void setQuestionIdx(int questionIdx) {
        this.questionIdx = questionIdx;
    }

    public void setImageAtlasIdx(int imageAtlasIdx) {
        this.imageAtlasIdx = imageAtlasIdx;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setDataString(String dataString) {
        this.data = dataString;
    }

    public void setQuestionEntry(QuestionEntry questionEntry) {
        this.questionEntry = questionEntry;
    }

    public void setImageAssetEntry(ImageAssetEntry imageAssetEntry) {
        this.imageAssetEntry = imageAssetEntry;
    }
}
