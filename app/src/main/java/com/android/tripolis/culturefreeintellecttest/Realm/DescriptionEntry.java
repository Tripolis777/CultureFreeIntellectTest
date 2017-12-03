package com.android.tripolis.culturefreeintellecttest.Realm;

import android.support.annotation.Nullable;
import android.util.Log;

import com.android.tripolis.culturefreeintellecttest.Realm.Description.ExamleEntryBuilder;
import com.android.tripolis.culturefreeintellecttest.Realm.Description.ExampleEntry;
import com.android.tripolis.culturefreeintellecttest.Realm.Description.ExampleEntryPackage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;

/**
 * Created by tripo on 11/14/2017.
 */

public class DescriptionEntry extends RealmObject {

    public enum DescriptionType {
        SIMPLE(1), WITH_IMAGES(2);

        private final int value;
        DescriptionType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Nullable
        public static DescriptionType getByValue(int value) {
            for ( DescriptionType type : DescriptionType.values()) {
                if (type.getValue() == value)
                    return type;
            }
            return null;
        }
    }

    public static class DescriptionEntryData {

        public static final String FIELD_TEST_NAME_KEY = "testName";
        public static final String FIELD_TEST_INFO_KEY = "testInfo";
        public static final String FIELD_EXAMPLES_COUNT_KEY = "examplesCount";
        public static final String FIELD_EXAMPLES_KEY = "examples";

        private String data;
        private String testNameKey;
        private String testInfoKey;
        private int examplesCount;

        private ExampleEntryPackage examples;

        public DescriptionEntryData(String data) {
            this.data = data;

            try {
                JSONObject jsonData = new JSONObject(data);
                testNameKey = jsonData.getString(FIELD_TEST_NAME_KEY);
                testInfoKey = jsonData.getString(FIELD_TEST_INFO_KEY);
                examplesCount = jsonData.getInt(FIELD_EXAMPLES_COUNT_KEY);

                examples = new ExampleEntryPackage();
                JSONArray examplesTitlesArray = jsonData.getJSONArray(FIELD_EXAMPLES_KEY);
                for (int i = 0; i < examplesTitlesArray.length(); i++) {
                    JSONObject exampleJson = examplesTitlesArray.getJSONObject(i);
                    ExamleEntryBuilder.createExample(exampleJson, examples);
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

        public ExampleEntryPackage getExamples() {
            return examples;
        }

        @Override
        public String toString() {
            return data;
        }

    }

    private int subtestIdx;
    private String dataString;
   // private int type;

    //private TestEntry test;

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

//    public void setTest(TestEntry test) {
//        this.test = test;
//    }
//
//    public TestEntry getTest() {
//        return test;
//    }

//    public void setType(DescriptionType type) {
//        this.type = type.getValue();
//    }
//
//    public DescriptionType getType() {
//        return  DescriptionType.values()[type];
//    }
}
