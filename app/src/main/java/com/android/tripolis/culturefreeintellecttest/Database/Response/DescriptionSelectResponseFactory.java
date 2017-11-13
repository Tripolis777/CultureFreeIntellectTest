package com.android.tripolis.culturefreeintellecttest.Database.Response;

import android.database.Cursor;

import com.android.tripolis.culturefreeintellecttest.Database.Entries.DescriptionEntry;

/**
 * Created by v.karyagin on 13.11.2017.
 */

public class DescriptionSelectResponseFactory extends SelectResponseFactory<DescriptionEntry> {
    @Override
    public SelectResponse<DescriptionEntry> getSelectResponse(Cursor cursor) {
        return new DescriptionSelectResponse(cursor);
    }
}
