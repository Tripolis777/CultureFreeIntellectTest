package com.android.tripolis.culturefreeintellecttest.Realm;

import io.realm.RealmObject;

/**
 * Created by tripo on 11/14/2017.
 */

public class AnswerEntry extends RealmObject {

    private int weight;
    private int type;
    private int num;
    private String data;

    //private QuestionEntry questionEntry;
    private ImageAssetEntry imageAssetEntry;

    public int getWeight() {
        return weight;
    }

    public int getType() {
        return type;
    }

    public String getDataString() {
        return data;
    }

    public ImageAssetEntry getImageAssetEntry() {
        return imageAssetEntry;
    }

    public int getNum() {
        return num;
    }

//    public QuestionEntry getQuestionEntry() {
//        return questionEntry;
//    }

    public void setNum(int num) {
        this.num = num;
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

//    public void setQuestionEntry(QuestionEntry questionEntry) {
//        this.questionEntry = questionEntry;
//    }

    public void setImageAssetEntry(ImageAssetEntry imageAssetEntry) {
        this.imageAssetEntry = imageAssetEntry;
    }

}
