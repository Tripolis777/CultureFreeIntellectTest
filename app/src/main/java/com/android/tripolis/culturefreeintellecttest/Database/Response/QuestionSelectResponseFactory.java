package com.android.tripolis.culturefreeintellecttest.Database.Response;

import android.database.Cursor;

import com.android.tripolis.culturefreeintellecttest.Database.Entries.QuestionEntry;

/**
 * Created by tripo on 11/13/2017.
 */

public class QuestionSelectResponseFactory extends SelectResponseFactory<QuestionEntry> {
    @Override
    public SelectResponse<QuestionEntry> getSelectResponse(Cursor cursor) {
        return new QuestionSelectResponse(cursor);
    }
}
