package com.android.tripolis.culturefreeintellecttest.Realm;

import io.realm.RealmObject;

/**
 * Created by v.karyagin on 20.11.2017.
 */

public class TestEntry extends RealmObject {

    private String name;
    private int subtestCount;

    public void setName(String name) {
        this.name = name;
    }

    public void setSubtestCount(int subtestCount) {
        this.subtestCount = subtestCount;
    }

    public String getName() {
        return name;
    }

    public int getSubtestCount() {
        return subtestCount;
    }
}
