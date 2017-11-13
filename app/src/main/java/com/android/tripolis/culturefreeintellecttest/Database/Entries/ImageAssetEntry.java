package com.android.tripolis.culturefreeintellecttest.Database.Entries;

import android.provider.BaseColumns;

/**
 * Created by tripo on 11/13/2017.
 */

public class ImageAssetEntry extends DatabaseEntry {

    public static abstract class ImageAssetSchema implements BaseColumns {
        public static final String TABLE_NAME = "image_asset";
        public static final String COLUMN_NAME = "resource_name";
    }

    private String resourceName;

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
}
