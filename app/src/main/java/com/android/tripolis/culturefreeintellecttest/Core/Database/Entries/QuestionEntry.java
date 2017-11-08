package com.android.tripolis.culturefreeintellecttest.Core.Database.Entries;

import android.provider.BaseColumns;

/**
 * Created by tripo on 11/4/2017.
 */

public class QuestionEntry implements DatabaseEntry {

    public static abstract class QuestionSchema implements BaseColumns {
        public static final String TABLE_NAME = "question";
        public static final String COLUMN_NAME_SUBTEST = "subtest";
        public static final String COLUMN_NAME_TEST_NUM = "test_num";
        public static final String COLUMN_NAME_ANSWER = "answer";
        public static final String COLUMN_NAME_TYPE = "type";
    }

}
