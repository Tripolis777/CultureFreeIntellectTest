package com.android.tripolis.culturefreeintellecttest.Core.Database.Entries;

import android.provider.BaseColumns;
import android.provider.ContactsContract;
import android.util.Log;

import com.android.tripolis.culturefreeintellecttest.Core.Description;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by tripo on 11/5/2017.
 */

public class DescriptionEntry implements DatabaseEntry {

    public static abstract class DescriptionSchema implements BaseColumns {
        public static final String TABLE_NAME = "description";
        public static final String COLUMN_NAME_SUBTEST = "subtest";
        public static final String COLUMN_NAME_DATA = "data";
    }

    public static class DescriptionEntryData {

        public static final String FIELD_TEST_NAME_KEY = "testName";
        public static final String FIELD_TEST_INFO_KEY = "testInfo";
        public static final String FIELD_EXAMPLES_COUNT_KEY = "examplesCount";
        public static final String FIELD_EXAMPLES_TITLES_KEY = "examplesTitles";

        private String data;
        private String testNameKey;
        private String testInfoKey;
        private int examplesCount;

        private String[] examplesTitleKey;

        public DescriptionEntryData(String data) {
            this.data = data;

            try {
                JSONObject jsonData = new JSONObject(data);
                testNameKey = jsonData.getString(FIELD_TEST_NAME_KEY);
                testInfoKey = jsonData.getString(FIELD_TEST_INFO_KEY);
                examplesCount = jsonData.getInt(FIELD_EXAMPLES_COUNT_KEY);

                examplesTitleKey = new String[examplesCount];
                JSONArray examplesTitlesArray = jsonData.getJSONArray(FIELD_EXAMPLES_TITLES_KEY);
                for (int i = 0; i < examplesTitlesArray.length(); i++) {
                    examplesTitleKey[i] = examplesTitlesArray.getString(i);
                }

            } catch (JSONException e) {
                Log.e("[Description data]", "Fail. Can't create json object." + e.getMessage().toString());
            }
        }

        public String getTestNameKey() {
            return testNameKey;
        }

        public String getTestInfoKey() {
            return testInfoKey;
        }

        public int getExamplesCount() {
            return examplesCount;
        }

        public String[] getExamplesTitleKeys() {
            return examplesTitleKey;
        }

    }

    private String dataString;
    private DescriptionEntryData data;

    public DescriptionEntryData getDescriptionData() {
        if (data == null)
            this.data = new DescriptionEntryData(this.dataString);

        return data;
    }

}
