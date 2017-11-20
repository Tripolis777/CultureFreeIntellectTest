package com.android.tripolis.culturefreeintellecttest.Realm.Description;

import android.util.Log;

import com.android.tripolis.culturefreeintellecttest.Realm.DescriptionEntry;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by v.karyagin on 20.11.2017.
 */

public class ExampleEntry {
    public static final String EXAMPLE_TITLE_KEY = "title";
    public static final String EXAMPLE_TYPE_KEY = "type";

    public String textTitleKey;
    public int type;

    public ExampleEntry(JSONObject json) throws JSONException {
        this.textTitleKey = json.getString(EXAMPLE_TITLE_KEY);
        this.type = json.getInt(EXAMPLE_TITLE_KEY);
    }

    public DescriptionEntry.DescriptionType getType() {
        return DescriptionEntry.DescriptionType.getByValue(type);
    }

    public static DescriptionEntry.DescriptionType getType(JSONObject object) throws JSONException {
        int type = object.getInt(EXAMPLE_TYPE_KEY);
        return DescriptionEntry.DescriptionType.getByValue(type);
    }

}
