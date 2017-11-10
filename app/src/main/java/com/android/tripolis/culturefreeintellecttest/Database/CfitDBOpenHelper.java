package com.android.tripolis.culturefreeintellecttest.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

/**
 * Created by v.karyagin on 10.11.2017.
 */

public class CfitDBOpenHelper extends SQLiteOpenHelper {

    private static CfitDBOpenHelper instance;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "CFIT.db";

    public static CfitDBOpenHelper getInstance(Context context, @Nullable SQLiteDatabase.CursorFactory factory) {
        if (instance == null)
            instance = new CfitDBOpenHelper(context, factory);
        return instance;
    }

    private CfitDBOpenHelper(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //new CfitDBOpenHelper().createDatabase(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //BoodiloDatabase.onUpgrade(sqLiteDatabase, i, i1);
    }
}
