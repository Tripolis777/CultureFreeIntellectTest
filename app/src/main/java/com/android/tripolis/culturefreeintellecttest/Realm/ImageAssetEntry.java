package com.android.tripolis.culturefreeintellecttest.Realm;

import io.realm.RealmObject;

/**
 * Created by tripo on 11/14/2017.
 */

public class ImageAssetEntry extends RealmObject {

    private String resourceName;

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
}
