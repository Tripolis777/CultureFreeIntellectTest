package com.android.tripolis.culturefreeintellecttest.Realm;

import android.graphics.Bitmap;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;

/**
 * Created by tripo on 11/14/2017.
 */

public class ImageAssetEntry extends RealmObject {

    private String resourceName;
    private int rowsCnt;
    private int columnsCnt;

    public String getResourceName() {
        return resourceName;
    }
    public int getRowsCnt() {
        return rowsCnt;
    }

    public int getColumnsCnt() {
        return columnsCnt;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public void setRowsCnt(int rowsCnt) {
        this.rowsCnt = rowsCnt;
    }

    public void setColumnsCnt(int columnsCnt) {
        this.columnsCnt = columnsCnt;
    }
}
