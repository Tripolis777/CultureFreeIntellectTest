package com.android.tripolis.culturefreeintellecttest.Database.Response;

import android.database.Cursor;

import java.util.ArrayList;

/**
 * Created by v.karyagin on 10.11.2017.
 */

public abstract class SelectResponse<T> {

    protected final ArrayList<T> rows;

    public SelectResponse(Cursor cursor) {
        rows = new ArrayList<>();
        init(cursor);
    }

    public ArrayList<T> getAll() {
        return rows;
    }

    protected abstract void init(Cursor cursor);
}