package com.android.tripolis.culturefreeintellecttest.Realm;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;

/**
 * Created by tripo on 11/14/2017.
 */

public class DescriptionEntry extends RealmObject {

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
                e.printStackTrace();
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

        @Override
        public String toString() {
            return data;
        }

    }

    private int subtestIdx;
    private String dataString;

    @Ignore
    private DescriptionEntryData data;

    public DescriptionEntryData getDescriptionData() {
        if (data == null)
            this.data = new DescriptionEntryData(this.dataString);

        return data;
    }

    public void setDescriptionData(DescriptionEntryData data) {
        this.data = data;
        this.dataString = data.toString();
    }

    public void setDescriptionData(String dataString) {
        this.dataString = dataString;
        this.data = new DescriptionEntryData(dataString);
    }

    public void setSubtestIdx(int subtestIdx) {
        this.subtestIdx = subtestIdx;
    }

    public int getSubtestIdx() {
        return subtestIdx;
    }

}
