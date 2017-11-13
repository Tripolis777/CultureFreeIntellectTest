package com.android.tripolis.culturefreeintellecttest.Database.Response;

import android.database.Cursor;

import com.android.tripolis.culturefreeintellecttest.Core.Question;
import com.android.tripolis.culturefreeintellecttest.Database.Entries.DescriptionEntry;
import com.android.tripolis.culturefreeintellecttest.Database.Entries.QuestionEntry;

/**
 * Created by tripo on 11/13/2017.
 */

public class QuestionSelectResponse extends SelectResponse<QuestionEntry> {
    public static final int JOIN_ANSWER = 0b001;
    public static final int JOIN_IMAGE_ASSET = 0b010;
    public static final int JOIN_TEST = 0b100;

    private final int flags;

    public QuestionSelectResponse(Cursor cursor) {
        this(cursor, 0);
    }

    public QuestionSelectResponse(Cursor cursor, int flags) {
        super(cursor);
        this.flags = flags;
    }

    @Override
    protected void init(Cursor cursor) {
        while(cursor.moveToNext()) {
            QuestionEntry entry = new QuestionEntry();


            this.rows.add(entry);
        }
    }
}
