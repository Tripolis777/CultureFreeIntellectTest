package com.android.tripolis.culturefreeintellecttest.Realm.Description;

import android.util.Log;

import com.android.tripolis.culturefreeintellecttest.Realm.DescriptionEntry;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by v.karyagin on 20.11.2017.
 */

public class ExamleEntryBuilder {

    public static ExampleEntry createExample(JSONObject object) {
        ExampleEntry example = null;
        try {
            DescriptionEntry.DescriptionType type = ExampleEntry.getType(object);
            switch (type) {
                case SIMPLE:
                    example = new ExampleEntry(object);
                case WITH_IMAGES:
                    example = new ExampleEntryImage(object);
                default:
                    example = new ExampleEntry(object);
            }
        } catch (JSONException e) {
            Log.e("[SimpleExample Builder]", "SimpleExample builder failure. Error: " + e.getMessage());
        }
        return example;
    }

}
