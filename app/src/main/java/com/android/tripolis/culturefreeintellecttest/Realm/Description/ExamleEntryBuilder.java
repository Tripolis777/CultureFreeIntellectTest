package com.android.tripolis.culturefreeintellecttest.Realm.Description;

import android.util.Log;

import com.android.tripolis.culturefreeintellecttest.Realm.DescriptionEntry;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by v.karyagin on 20.11.2017.
 */

public class ExamleEntryBuilder {

    public static void createExample(JSONObject object, ExampleEntryPackage examplesPackage) {
        try {
            DescriptionEntry.DescriptionType type = ExampleEntry.getType(object);
            switch (type) {
                case SIMPLE:
                    examplesPackage.put(new ExampleEntry(object));
                case WITH_IMAGES:
                    examplesPackage.put(new ExampleEntryImage(object));
                default:
                    examplesPackage.put(new ExampleEntry(object));
            }
        } catch (JSONException e) {
            Log.e("[SimpleExample Builder]", "SimpleExample builder failure. Error: " + e.getMessage());
        }
    }

}
