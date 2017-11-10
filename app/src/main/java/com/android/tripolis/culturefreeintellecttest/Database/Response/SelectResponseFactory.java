package com.android.tripolis.culturefreeintellecttest.Database.Response;

import android.database.Cursor;

/**
 * Created by v.karyagin on 10.11.2017.
 */

public abstract class SelectResponseFactory<T> {
    public abstract SelectResponse<T> getSelectResponse(Cursor cursor);
}