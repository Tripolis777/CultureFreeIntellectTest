package com.android.tripolis.culturefreeintellecttest.Database.Response;

import android.database.Cursor;

import com.android.tripolis.culturefreeintellecttest.Database.Entries.DescriptionEntry;

/**
 * Created by v.karyagin on 13.11.2017.
 */

public class DescriptionSelectResponse extends SelectResponse<DescriptionEntry> {
    public DescriptionSelectResponse(Cursor cursor) {
        super(cursor);
    }

    @Override
    protected void init(Cursor cursor) {
        while (cursor.moveToNext()) {
            DescriptionEntry entry = new DescriptionEntry();
            entry.setSubtestIdx(cursor.getInt(
                    cursor.getColumnIndex(DescriptionEntry.DescriptionSchema.COLUMN_NAME_SUBTEST)));
            entry.setDescriptionData(cursor.getString(
                    cursor.getColumnIndex(DescriptionEntry.DescriptionSchema.COLUMN_NAME_DATA)));

            this.rows.add(entry);
        }
    }
}
