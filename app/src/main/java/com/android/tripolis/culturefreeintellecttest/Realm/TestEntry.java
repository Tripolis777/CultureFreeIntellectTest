package com.android.tripolis.culturefreeintellecttest.Realm;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by v.karyagin on 20.11.2017.
 */

public class TestEntry extends RealmObject {

    private String name;
    private DescriptionEntry testDescription;
    private RealmList<SubtestEntry> subtestList;

    public String getName() {
        return name;
    }

    public RealmList<SubtestEntry> getSubtestList() {
        return subtestList;
    }

    public int getSubtestCount() {
        return subtestList.size();
    }

    public DescriptionEntry getTestDescription() {
        return testDescription;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubtestList(RealmList<SubtestEntry> subtestList) {
        this.subtestList = subtestList;
    }

    public void addSubtest(SubtestEntry subtestEntry) {
        this.subtestList.add(subtestEntry);
    }

    public void setTestDescription(DescriptionEntry testDescription) {
        this.testDescription = testDescription;
    }
}
