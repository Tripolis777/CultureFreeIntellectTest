package com.android.tripolis.culturefreeintellecttest.Core;

import android.content.Context;
import android.util.Log;

import com.android.tripolis.culturefreeintellecttest.Realm.QuestionEntry;

import java.util.ArrayList;

import io.realm.RealmList;

/**
 * Created by tripo on 11/4/2017.
 */

public class QuestionManager {

    private FragmentFactory<Question> fragmentFactory;
    private ArrayList<Question> questions;
    private final AssetManager assetManager;

    private int questionsCount;

    public QuestionManager(RealmList<QuestionEntry> questionEntries, final AssetManager assetManager) {
        questions = new ArrayList<>();
        this.assetManager = assetManager;

        for (QuestionEntry entry : questionEntries) {
            questions.add(new Question(entry, assetManager));
        }
    }

//    public FragmentFactory<Question> getFragmentFactory() {
//        return fragmentFactory;
//    }

    public Question getQuestion(int questionNum) {
        if (questionNum > questions.size()) {
            Log.e("[QuestionManager]", "Cant get question. Question num biggest questions count.");
            throw new NullPointerException();    // TODO: replace to self exception
        }

        return questions.get(questionNum);
    }

    public String getQuestionTitle(int position) {
        return null;
    }

    public int getQuestionsCount() {
        return questions.size();
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

}
