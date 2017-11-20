package com.android.tripolis.culturefreeintellecttest.Realm.Description;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by v.karyagin on 20.11.2017.
 */

public class ExampleEntryImage extends ExampleEntry {

    public static final String EXAMPLE_IMAGE_KEY = "image_key";
    public static final String EXAMPLE_IMAGE_NAME_KEY = "image_name_key";
    public static final String EXAMPLE_IMAGE_INFO_KEY = "image_info_key";


    public String imageKey;
    public String textImageNameKey;
    public String textImageInfoKey;

    public ExampleEntryImage(final JSONObject jsonObject) throws JSONException {
        super(jsonObject);

        this.imageKey = jsonObject.getString(EXAMPLE_IMAGE_KEY);
        this.textImageNameKey = jsonObject.getString(EXAMPLE_IMAGE_NAME_KEY);
        this.textImageInfoKey = jsonObject.getString(EXAMPLE_IMAGE_INFO_KEY);
    }
}
