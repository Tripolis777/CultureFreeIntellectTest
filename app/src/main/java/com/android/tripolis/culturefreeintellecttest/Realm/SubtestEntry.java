package com.android.tripolis.culturefreeintellecttest.Realm;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by tripo on 12/1/2017.
 */

public class SubtestEntry extends RealmObject {

    private int index;
    private DescriptionEntry subtestDesctiprion;
    private RealmList<QuestionEntry> questionsList;

    public int getIndex() {
        return index;
    }

    public DescriptionEntry getSubtestDesctiprion() {
        return subtestDesctiprion;
    }

    public RealmList<QuestionEntry> getQuestionsList() {
        return questionsList;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setSubtestDesctiprion(DescriptionEntry subtestDesctiprion) {
        this.subtestDesctiprion = subtestDesctiprion;
    }

    public void setQuestionsList(RealmList<QuestionEntry> questionsList) {
        this.questionsList = questionsList;
    }

    public void addQuestion(QuestionEntry questionEntry) {
        this.questionsList.add(questionEntry);
    }
}
